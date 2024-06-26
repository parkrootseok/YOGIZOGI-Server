package dev.yogizogi.global.util;

import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisUtils {

    private final RedisTemplate<String, String> redisTemplate;

    /**
     * 데이터 생성 (유효 시간 설정 포함)
     */
    public void saveWithExpirationTime(String key, String value, long duration) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key, value, expireDuration);
    }

    /**
     * 키 값으로 데이터 가져오기
     */
    public String findByKey(String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * 키 값으로 데이터 유무 확인
     */
    public boolean isExist(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }


    /**
     * 데이터 삭제
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
