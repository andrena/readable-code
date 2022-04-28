package de.andrena.readablecode.naming;

public class InTemporaryVariables {
	
	public String getViolationElement1(String propertyPath) {
        String[] splitProperty = propertyPath.split("\\.", 3);
        /** precise but not recallable */
        String propertySubStringAfterSecondDot = splitProperty[splitProperty.length - 1];
        return propertySubStringAfterSecondDot;
    }

	public String getViolationElement2(String propertyPath) {
		/** without variables, describing the whole process */
		return new StringExtractor(propertyPath)
			.consumeUntil('.')
			.consumeUntil('.')
			.remainder();
    }
	
	public static class StringExtractor {

		private String remainder;

		public StringExtractor(String remainder) {
			this.remainder = remainder;
		}

		public StringExtractor consumeUntil(char c) {
			int pos = remainder.indexOf(c); 
			remainder = remainder.substring(pos+1);
			return this;
		}

		public String remainder() {
			return remainder;
		}
		
	}
}