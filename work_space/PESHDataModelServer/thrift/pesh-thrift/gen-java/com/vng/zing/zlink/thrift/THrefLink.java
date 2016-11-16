/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vng.zing.zlink.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THrefLink implements org.apache.thrift.TBase<THrefLink, THrefLink._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("THrefLink");

  private static final org.apache.thrift.protocol.TField TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("text", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField HREF_FIELD_DESC = new org.apache.thrift.protocol.TField("href", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new THrefLinkStandardSchemeFactory());
    schemes.put(TupleScheme.class, new THrefLinkTupleSchemeFactory());
  }

  public String text; // optional
  public String href; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TEXT((short)1, "text"),
    HREF((short)2, "href");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TEXT
          return TEXT;
        case 2: // HREF
          return HREF;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private _Fields optionals[] = {_Fields.TEXT,_Fields.HREF};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TEXT, new org.apache.thrift.meta_data.FieldMetaData("text", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HREF, new org.apache.thrift.meta_data.FieldMetaData("href", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(THrefLink.class, metaDataMap);
  }

  public THrefLink() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public THrefLink(THrefLink other) {
    if (other.isSetText()) {
      this.text = other.text;
    }
    if (other.isSetHref()) {
      this.href = other.href;
    }
  }

  public THrefLink deepCopy() {
    return new THrefLink(this);
  }

  @Override
  public void clear() {
    this.text = null;
    this.href = null;
  }

  public String getText() {
    return this.text;
  }

  public THrefLink setText(String text) {
    this.text = text;
    return this;
  }

  public void unsetText() {
    this.text = null;
  }

  /** Returns true if field text is set (has been assigned a value) and false otherwise */
  public boolean isSetText() {
    return this.text != null;
  }

  public void setTextIsSet(boolean value) {
    if (!value) {
      this.text = null;
    }
  }

  public String getHref() {
    return this.href;
  }

  public THrefLink setHref(String href) {
    this.href = href;
    return this;
  }

  public void unsetHref() {
    this.href = null;
  }

  /** Returns true if field href is set (has been assigned a value) and false otherwise */
  public boolean isSetHref() {
    return this.href != null;
  }

  public void setHrefIsSet(boolean value) {
    if (!value) {
      this.href = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TEXT:
      if (value == null) {
        unsetText();
      } else {
        setText((String)value);
      }
      break;

    case HREF:
      if (value == null) {
        unsetHref();
      } else {
        setHref((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TEXT:
      return getText();

    case HREF:
      return getHref();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TEXT:
      return isSetText();
    case HREF:
      return isSetHref();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof THrefLink)
      return this.equals((THrefLink)that);
    return false;
  }

  public boolean equals(THrefLink that) {
    if (that == null)
      return false;

    boolean this_present_text = true && this.isSetText();
    boolean that_present_text = true && that.isSetText();
    if (this_present_text || that_present_text) {
      if (!(this_present_text && that_present_text))
        return false;
      if (!this.text.equals(that.text))
        return false;
    }

    boolean this_present_href = true && this.isSetHref();
    boolean that_present_href = true && that.isSetHref();
    if (this_present_href || that_present_href) {
      if (!(this_present_href && that_present_href))
        return false;
      if (!this.href.equals(that.href))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(THrefLink other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    THrefLink typedOther = (THrefLink)other;

    lastComparison = Boolean.valueOf(isSetText()).compareTo(typedOther.isSetText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.text, typedOther.text);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHref()).compareTo(typedOther.isSetHref());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHref()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.href, typedOther.href);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("THrefLink(");
    boolean first = true;

    if (isSetText()) {
      sb.append("text:");
      if (this.text == null) {
        sb.append("null");
      } else {
        sb.append(this.text);
      }
      first = false;
    }
    if (isSetHref()) {
      if (!first) sb.append(", ");
      sb.append("href:");
      if (this.href == null) {
        sb.append("null");
      } else {
        sb.append(this.href);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class THrefLinkStandardSchemeFactory implements SchemeFactory {
    public THrefLinkStandardScheme getScheme() {
      return new THrefLinkStandardScheme();
    }
  }

  private static class THrefLinkStandardScheme extends StandardScheme<THrefLink> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, THrefLink struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.text = iprot.readString();
              struct.setTextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HREF
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.href = iprot.readString();
              struct.setHrefIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, THrefLink struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.text != null) {
        if (struct.isSetText()) {
          oprot.writeFieldBegin(TEXT_FIELD_DESC);
          oprot.writeString(struct.text);
          oprot.writeFieldEnd();
        }
      }
      if (struct.href != null) {
        if (struct.isSetHref()) {
          oprot.writeFieldBegin(HREF_FIELD_DESC);
          oprot.writeString(struct.href);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class THrefLinkTupleSchemeFactory implements SchemeFactory {
    public THrefLinkTupleScheme getScheme() {
      return new THrefLinkTupleScheme();
    }
  }

  private static class THrefLinkTupleScheme extends TupleScheme<THrefLink> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, THrefLink struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetText()) {
        optionals.set(0);
      }
      if (struct.isSetHref()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetText()) {
        oprot.writeString(struct.text);
      }
      if (struct.isSetHref()) {
        oprot.writeString(struct.href);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, THrefLink struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.text = iprot.readString();
        struct.setTextIsSet(true);
      }
      if (incoming.get(1)) {
        struct.href = iprot.readString();
        struct.setHrefIsSet(true);
      }
    }
  }

}
