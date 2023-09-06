package tommy.mytommy.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tommy.mytommy.entity.Comment;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
               comment.getId(),
               comment.getArticle().getId(),
               comment.getNickname(),
               comment.getBody());
    }

    public Long getId() {
        return id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public String getNickname(){
        return nickname;
    }
    public String getBody() {
        return body;
    }
}
