import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity extends BaseIdEntity {

    @CreatedDate
    @Column(nullable = false)
    private LocalDate localDate;
}