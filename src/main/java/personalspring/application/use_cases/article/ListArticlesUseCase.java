package personalspring.application.use_cases.article;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class ListArticlesUseCase {
    private final IArticleRepository repository;

    public List<Article> execut() {
        return this.repository.list();
    }
}
