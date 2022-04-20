package de.andrena.readablecode.bad;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class Bad1Test {

	private Bad1 bad1;
	private Bad1 bad2;

	@BeforeEach
	void before() throws Exception {
		bad1 = new Bad1("label1");
		bad2 = new Bad1("label2");
	}

	@Test
	void testInitial() {
		assertThat(bad1.label()).isEqualTo("label1");
		assertThat(bad2.label()).isEqualTo("label2");
	}

	@Test
	void testFoo() {
		bad1.foo(bad2);
		assertThat(bad2.label()).isEqualTo("label2");
		assertThat(bad1.label()).isEqualTo("label2");
	}

	@Test
	void testBar() {
		assertThat(bad1.bar(bad2)).isEqualTo("label2");
		assertThat(bad2.bar(bad1)).isEqualTo("label1");
		
		assertThat(bad2.label()).isEqualTo("label2");
	}

}
