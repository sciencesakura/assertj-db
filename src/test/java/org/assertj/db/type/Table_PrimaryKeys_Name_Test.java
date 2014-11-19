package org.assertj.db.type;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.db.common.AbstractTest;
import org.assertj.db.exception.AssertJDBException;
import org.junit.Test;

/**
 * Tests on the primary keys name of {@code Table}.
 * <p>
 * These tests are on the name of the primary keys got from a {@code Table}.
 * </p>
 * 
 * @author Régis Pouiller
 * 
 */
public class Table_PrimaryKeys_Name_Test extends AbstractTest {

  /**
   * This method test the primary keys got from a {@code Source}.
   */
  @Test
  public void test_pks_name_with_source_set() {
    Table table = new Table(source, "movie");

    assertThat(table.getPksNameList()).as("Primary Keys of MOVIE table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method test the primary keys got from a {@code DataSource}.
   */
  @Test
  public void test_pks_name_with_datasource_set() {
    Table table = new Table(dataSource, "movie");

    assertThat(table.getPksNameList()).as("Primary Keys of MOVIE table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method test the primary keys got from a {@code Source} when the columns to check are set.
   */
  @Test
  public void test_pks_name_to_check_with_source_set() {
    Table table = new Table(source, "actor", new String[] { "id", "name", "birth" }, null);

    assertThat(table.getPksNameList()).as("Primary Keys of ACTOR table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method test the primary keys got from a {@code DataSource} when the columns to check are set.
   */
  @Test
  public void test_pks_name_to_check_with_datasource_set() {
    Table table = new Table(dataSource, "actor", new String[] { "id", "name", "birth" }, null);

    assertThat(table.getPksNameList()).as("Primary Keys of ACTOR table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method test the primary keys got from a {@code Source} when the columns to exclude are set.
   */
  @Test
  public void test_pks_name_to_exclude_with_source_set() {
    Table table = new Table(source, "interpretation", null, new String[] { "id" });

    assertThat(table.getPksNameList()).as("Primary Keys of INTERPRETATION table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method test the primary keys got from a {@code DataSource} when the columns to exclude are set.
   */
  @Test
  public void test_pks_name_to_exclude_with_datasource_set() {
    Table table = new Table(dataSource, "interpretation", null, new String[] { "id" });

    assertThat(table.getPksNameList()).as("Primary Keys of INTERPRETATION table").hasSize(1)
        .containsExactly("ID");
  }

  /**
   * This method should throw a {@code AssertJDBException} because of a {@code SQLException} caused by a table not
   * found.
   */
  @Test(expected = AssertJDBException.class)
  public void should_throw_AssertJDBException_because_SQLException_caused_by_table_not_found() {
    Table table = new Table(dataSource, "interpret");
    table.getPksNameList();
  }

}