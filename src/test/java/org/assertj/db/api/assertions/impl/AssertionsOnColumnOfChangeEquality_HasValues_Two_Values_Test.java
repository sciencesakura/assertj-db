package org.assertj.db.api.assertions.impl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.db.api.TableAssert;
import org.assertj.db.type.Table;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * Tests on {@link org.assertj.db.api.assertions.impl.AssertionsOnColumnOfChangeEquality} class :
 * {@link org.assertj.db.api.assertions.impl.AssertionsOnColumnOfChangeEquality#hasValues(org.assertj.db.api.AbstractAssert, org.assertj.core.api.WritableAssertionInfo, Object, Object, Object, Object)} method.
 *
 * @author Régis Pouiller
 *
 */
public class AssertionsOnColumnOfChangeEquality_HasValues_Two_Values_Test {

  /**
   * This method tests the {@code hasValues} assertion method.
   */
  @Test
  public void test_has_values() {
    WritableAssertionInfo info = new WritableAssertionInfo();
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    TableAssert tableAssert2 = AssertionsOnColumnOfChangeEquality.hasValues(tableAssert, info, Locale.FRENCH, Locale.ENGLISH, Locale.FRENCH, Locale.ENGLISH);
    Assertions.assertThat(tableAssert2).isSameAs(tableAssert);
  }

  /**
   * This method should fail because the value at start point is different.
   */
  @Test
  public void should_fail_because_value_at_start_point_is_different() {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnColumnOfChangeEquality.hasValues(tableAssert, info, Locale.FRENCH, Locale.ENGLISH, Locale.ENGLISH, Locale.ENGLISH);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting that start point:%n"
                                                                    + "  <fr>%n"
                                                                    + "to be equal to: %n"
                                                                    + "  <en>"));
    }
  }

  /**
   * This method should fail because the value at end point is different.
   */
  @Test
  public void should_fail_because_value_at_end_point_is_different() {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnColumnOfChangeEquality.hasValues(tableAssert, info, Locale.FRENCH, Locale.ENGLISH, Locale.FRENCH, Locale.FRENCH);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting that end point:%n"
                                                                    + "  <en>%n"
                                                                    + "to be equal to: %n"
                                                                    + "  <fr>"));
    }
  }

  /**
   * This method should fail because one of the values is not a object.
   */
  @Test
  public void should_fail_because_one_value_is_not_a_object() {
    WritableAssertionInfo info = new WritableAssertionInfo();
    info.description("description");
    Table table = new Table();
    TableAssert tableAssert = assertThat(table);
    try {
      AssertionsOnColumnOfChangeEquality.hasValues(tableAssert, info, "other", Locale.ENGLISH, Locale.FRENCH, Locale.ENGLISH);
      fail("An exception must be raised");
    } catch (AssertionError e) {
      Assertions.assertThat(e.getMessage()).isEqualTo(String.format("[description] %n"
                                                                    + "Expecting that the value at start point:%n"
                                                                    + "  <\"other\">%n"
                                                                    + "to be of class%n"
                                                                    + "  <java.util.Locale>%n"
                                                                    + "but was of class%n"
                                                                    + "  <java.lang.String>"));
    }
  }
}
