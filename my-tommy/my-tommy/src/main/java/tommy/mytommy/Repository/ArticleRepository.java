package tommy.mytommy.Repository;

import org.springframework.data.repository.CrudRepository;
import tommy.mytommy.entity.Article;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
}

