/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vng.zing.zlink.thrift;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

public enum TCateType implements org.apache.thrift.TEnum {
  UNKNOWN(0),
  NEW_LINK(100),
  HOT_LINK(102);

  private final int value;

  private TCateType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static TCateType findByValue(int value) { 
    switch (value) {
      case 0:
        return UNKNOWN;
      case 100:
        return NEW_LINK;
      case 102:
        return HOT_LINK;
      default:
        return null;
    }
  }
}