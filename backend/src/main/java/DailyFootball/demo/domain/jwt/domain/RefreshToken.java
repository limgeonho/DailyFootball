package DailyFootball.demo.domain.jwt.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RDB 방식으로 구현 -> 배치 작업을 통해 만료된 토큰 삭제 필요
 * 자동으로 삭제 하려면 Redis 를 사용해서 나중에 업데이트 필요
 */

@Getter
@NoArgsConstructor
@Table(name = "REFRESH_TOKEN")
@Entity
public class RefreshToken {

    @Id
    private String key;
    private String value;

    public RefreshToken updateValue(String token){
        this.value = token;
        return this;
    }

    @Builder
    public RefreshToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
