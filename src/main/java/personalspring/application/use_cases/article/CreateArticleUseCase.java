package personalspring.application.use_cases.article;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@Service
@AllArgsConstructor
public class CreateArticleUseCase {
    private final IArticleRepository repository;

    public UUID execut(Article model) {
        var entity = repository.create(model);

        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found");
        }

        return entity.getId();
    }
}
