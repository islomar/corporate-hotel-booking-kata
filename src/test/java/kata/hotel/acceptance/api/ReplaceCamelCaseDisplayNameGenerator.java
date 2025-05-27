/* (C)2025 */
package kata.hotel.acceptance.api;

import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayNameGenerator;

// https://leeturner.me/post/building-a-camel-case-junit5-displaynamegenerator/
public class ReplaceCamelCaseDisplayNameGenerator extends DisplayNameGenerator.Standard {
  public ReplaceCamelCaseDisplayNameGenerator() {}

  public String generateDisplayNameForClass(Class<?> testClass) {
    return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
  }

  public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
    return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
  }

  public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
    return this.replaceCapitals(testMethod.getName());
  }

  private String replaceCapitals(String name) {
    name = name.replaceAll("([A-Z])", " $1");
    name = name.replaceAll("([0-9]+)", " $1");
    return name;
  }
}
