package exercise;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;



class ValidationTest {

    @Test
    void testValidate() {
        Address address1 = new Address("Russia", "Ufa", "Lenina", "54", null);
        List<String> result1 = Validator.validate(address1);
        List<String> expected1 = List.of();
        assertThat(result1).isEqualTo(expected1);

        Address address2 = new Address(null, "London", "1-st street", "5", "1");
        List<String> result2 = Validator.validate(address2);
        List<String> expected2 = List.of("country");
        assertThat(result2).isEqualTo(expected2);

        Address address3 = new Address("USA", null, null, null, "1");
        List<String> result3 = Validator.validate(address3);
        List<String> expected3 = List.of("city", "street", "houseNumber");
        assertThat(result3).isEqualTo(expected3);


        // BEGIN
        class TestClass {
            @NotNull
            private String notNullField;

            @MinLength()
            private String minLengthField;

            @MinLength()
            private String validLengthField;

            private String noAnnotationField;

            public TestClass(String notNullField, String minLengthField, String validLengthField, String noAnnotationField) {
                this.notNullField = notNullField;
                this.minLengthField = minLengthField;
                this.validLengthField = validLengthField;
                this.noAnnotationField = noAnnotationField;
            }

            @Test
            public void testAdvancedValidate_MinLengthFieldTooShort() {
                TestClass testObject = new TestClass("notNull", "short", "validLength", "noAnnotation");
                Map<String, List<String>> errors = Validator.advancedValidate(testObject);

                assertTrue(errors.containsKey("minLengthField"));
                assertTrue(errors.get("minLengthField").contains("Длина строки должна быть не менее 5 символов."));
            }

            @Test
            public void testAdvancedValidate_ValidLengthField() {
                TestClass testObject = new TestClass("notNull", "correctLength", "validLength", "noAnnotation");
                Map<String, List<String>> errors = Validator.advancedValidate(testObject);

                assertFalse(errors.containsKey("minLengthField"));
                assertFalse(errors.containsKey("validLengthField"));
            }
            // END
        }
    }
}