package de.andrena.readablecode.stefan.compositions.b;

import java.math.BigDecimal;
import java.util.List;

public class Product {

	/** Magic Complexity =             0 */
	public int id;                   //+1
	public Label label;              //+1
	public Supply supply;            //+1
	public UserFeedback userFeedback;//+1
	/**                                4 */

	public static class Supply {
		public BigDecimal price;
		public int available;

		public Supply() {
		}
	}

	public static class Label {
		public String title;
		public String description;

		public Label() {
		}
	}

	public static class UserFeedback {
		public List<String> comments;
		public List<Integer> stars;

		public UserFeedback() {
		}
	}

}
