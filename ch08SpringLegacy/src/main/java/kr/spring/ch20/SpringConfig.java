package kr.spring.ch20;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 코드 기반 설정
@Configuration
public class SpringConfig {
	//@Bean 어노테이션을 명시함으로써 bean 객체 설정
	@Bean
	public Worker worker() {
		return new Worker();
	}
	
	@Bean
	/*
	 * @Bean를 명시해서 빈 객체를 생성할 때는 지정한 메서드명을
	 * 빈 객체의 이름으로 사용
	 * @Bean("빈이름")이와 같이 빈이름을 지정할 수 있음.
	 * 
	 * @Bean
	 * @Named("빈이름")은 허용되지 않음
	 */
	public Executor executor() {
		return new Executor();
	}
	
}
