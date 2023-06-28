package personalspring.application.use_cases.article;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;

import personalspring.domain.models.Article;
import personalspring.domain.repositories.IArticleRepository;

@ExtendWith(MockitoExtension.class)
class CreateUseCaseTest {
    @Mock
    private IArticleRepository repository;

    @InjectMocks
    private CreateArticleUseCase useCase;

    Faker faker = new Faker();

    @Test
    void should_return_only_id_from_created_entity() {
        UUID id = UUID.randomUUID();
        String slug = faker.name().fullName().replace(' ', '-').toLowerCase();
        when(repository.create(any(Article.class))).thenReturn(Article.builder().id(id).slug(slug).build());

        var result = useCase.execut(Article.builder().slug(slug).build());
        assertEquals(result, id);
    }

}
