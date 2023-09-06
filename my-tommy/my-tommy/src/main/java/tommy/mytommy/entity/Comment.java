package tommy.mytommy.entity;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tommy.mytommy.DTO.CommentDto;

@Entity
@ToString
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//DB가 자동으로 1씩 증가
    private Long id; // 대표키

    @ManyToOne // Comment 엔티티와 Article 엔티티를 다대일 관계로 설정
    @JoinColumn(name="article_id") // 외래키 생성, Article 엔티티의 기본키(id)와 매핑

    private Article article; // 부모 게시글
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        // 예외 발생
        if(dto.getId() != null)
            throw new IllegalStateException("댓글 생성 실패! 댓글의 id가 없어야합니다.");
        if(dto.getArticleId() != article.getId())
            throw new IllegalStateException("댓글 생성 실패! 게시글의 id가 잘못되었습니다.");
        // 엔티티 생성, 반환
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getNickname() {
        return nickname;
    }

    public Article getArticle() {
        return article;
    }

    public Comment(){};

    public void patch(CommentDto dto) {
        // 예외 처리
        if(this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력되었습니다.");
        if(dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();
        // 객체
    }
}
