package de.andrena.readablecode.groupingandaligning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import de.andrena.readablecode.groupingandaligning.GroupingAligning.MyObject;

public class GroupingAligningTest {

	@Test
	public void testSomeUnit() {
		GroupingAligning groupingAligning = new GroupingAligning();
		MyObject myObject42 = new MyObject();
		myObject42.setValue(42);
		MyObject myObject815 = new MyObject();
		myObject815.setValue(815);

		groupingAligning.swap(myObject42, myObject815);

		assertThat(myObject42.value()).isEqualTo(815);
		assertThat(myObject815.value()).isEqualTo(42);
	}

}
