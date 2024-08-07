package personalspring.infrastructure.database.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import personalspring.domain.models.Article;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity<Article> {

  @Column(nullable = false)
  private String slug;

  @Column(nullable = false)
  private String body;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private boolean favorited = false;

  @Column(nullable = false)
  private int favoritesCount = 0;

  @Column(nullable = false)
  private String title;

  public ArticleEntity(Article model) {
    this.setId(model.getId());
    this.slug = model.getSlug();
    this.body = model.getBody();
    this.description = model.getDescription();
    this.favorited = model.isFavorited();
    this.favoritesCount = model.getFavoritesCount();
    this.title = model.getTitle();
    this.setCreatedAt(model.getCreatedAt());
    this.setUpdatedAt(model.getUpdatedAt());
  }

  @Override
  public Article toModel() {
    return Article.builder()
        .id(this.getId())
        .slug(this.slug)
        .body(this.body)
        .description(this.description)
        .favorited(this.favorited)
        .favoritesCount(this.favoritesCount)
        .title(this.title)
        .createdAt(this.getCreatedAt())
        .updatedAt(this.getUpdatedAt())
        .build();
  }
}
