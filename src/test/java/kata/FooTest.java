/* (C)2024 */
package kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class FooTest {

  @Test
  public void please_give_me_a_good_name() {
    Foo foo = new Foo();

    int result = foo.add(1, 41);

    assertThat(result, is(42));
  }
}
