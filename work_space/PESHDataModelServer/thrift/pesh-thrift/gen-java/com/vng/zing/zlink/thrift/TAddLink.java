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

public class TAddLink implements org.apache.thrift.TBase<TAddLink, TAddLink._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TAddLink");

  private static final org.apache.thrift.protocol.TField URL_FIELD_DESC = new org.apache.thrift.protocol.TField("url", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField EXTRA_FIELD_DESC = new org.apache.thrift.protocol.TField("extra", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TAddLinkStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TAddLinkTupleSchemeFactory());
  }

  public String url; // required
  public TLinkExtra extra; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    URL((short)1, "url"),
    EXTRA((short)2, "extra");

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
        case 1: // URL
          return URL;
        case 2: // EXTRA
          return EXTRA;
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
  private _Fields optionals[] = {_Fields.EXTRA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.URL, new org.apache.thrift.meta_data.FieldMetaData("url", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.EXTRA, new org.apache.thrift.meta_data.FieldMetaData("extra", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TLinkExtra.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TAddLink.class, metaDataMap);
  }

  public TAddLink() {
  }

  public TAddLink(
    String url)
  {
    this();
    this.url = url;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TAddLink(TAddLink other) {
    if (other.isSetUrl()) {
      this.url = other.url;
    }
    if (other.isSetExtra()) {
      this.extra = new TLinkExtra(other.extra);
    }
  }

  public TAddLink deepCopy() {
    return new TAddLink(this);
  }

  @Override
  public void clear() {
    this.url = null;
    this.extra = null;
  }

  public String getUrl() {
    return this.url;
  }

  public TAddLink setUrl(String url) {
    this.url = url;
    return this;
  }

  public void unsetUrl() {
    this.url = null;
  }

  /** Returns true if field url is set (has been assigned a value) and false otherwise */
  public boolean isSetUrl() {
    return this.url != null;
  }

  public void setUrlIsSet(boolean value) {
    if (!value) {
      this.url = null;
    }
  }

  public TLinkExtra getExtra() {
    return this.extra;
  }

  public TAddLink setExtra(TLinkExtra extra) {
    this.extra = extra;
    return this;
  }

  public void unsetExtra() {
    this.extra = null;
  }

  /** Returns true if field extra is set (has been assigned a value) and false otherwise */
  public boolean isSetExtra() {
    return this.extra != null;
  }

  public void setExtraIsSet(boolean value) {
    if (!value) {
      this.extra = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case URL:
      if (value == null) {
        unsetUrl();
      } else {
        setUrl((String)value);
      }
      break;

    case EXTRA:
      if (value == null) {
        unsetExtra();
      } else {
        setExtra((TLinkExtra)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case URL:
      return getUrl();

    case EXTRA:
      return getExtra();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case URL:
      return isSetUrl();
    case EXTRA:
      return isSetExtra();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TAddLink)
      return this.equals((TAddLink)that);
    return false;
  }

  public boolean equals(TAddLink that) {
    if (that == null)
      return false;

    boolean this_present_url = true && this.isSetUrl();
    boolean that_present_url = true && that.isSetUrl();
    if (this_present_url || that_present_url) {
      if (!(this_present_url && that_present_url))
        return false;
      if (!this.url.equals(that.url))
        return false;
    }

    boolean this_present_extra = true && this.isSetExtra();
    boolean that_present_extra = true && that.isSetExtra();
    if (this_present_extra || that_present_extra) {
      if (!(this_present_extra && that_present_extra))
        return false;
      if (!this.extra.equals(that.extra))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TAddLink other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TAddLink typedOther = (TAddLink)other;

    lastComparison = Boolean.valueOf(isSetUrl()).compareTo(typedOther.isSetUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.url, typedOther.url);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetExtra()).compareTo(typedOther.isSetExtra());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExtra()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.extra, typedOther.extra);
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
    StringBuilder sb = new StringBuilder("TAddLink(");
    boolean first = true;

    sb.append("url:");
    if (this.url == null) {
      sb.append("null");
    } else {
      sb.append(this.url);
    }
    first = false;
    if (isSetExtra()) {
      if (!first) sb.append(", ");
      sb.append("extra:");
      if (this.extra == null) {
        sb.append("null");
      } else {
        sb.append(this.extra);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (url == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'url' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (extra != null) {
      extra.validate();
    }
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

  private static class TAddLinkStandardSchemeFactory implements SchemeFactory {
    public TAddLinkStandardScheme getScheme() {
      return new TAddLinkStandardScheme();
    }
  }

  private static class TAddLinkStandardScheme extends StandardScheme<TAddLink> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TAddLink struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.url = iprot.readString();
              struct.setUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // EXTRA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.extra = new TLinkExtra();
              struct.extra.read(iprot);
              struct.setExtraIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TAddLink struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.url != null) {
        oprot.writeFieldBegin(URL_FIELD_DESC);
        oprot.writeString(struct.url);
        oprot.writeFieldEnd();
      }
      if (struct.extra != null) {
        if (struct.isSetExtra()) {
          oprot.writeFieldBegin(EXTRA_FIELD_DESC);
          struct.extra.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TAddLinkTupleSchemeFactory implements SchemeFactory {
    public TAddLinkTupleScheme getScheme() {
      return new TAddLinkTupleScheme();
    }
  }

  private static class TAddLinkTupleScheme extends TupleScheme<TAddLink> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TAddLink struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.url);
      BitSet optionals = new BitSet();
      if (struct.isSetExtra()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetExtra()) {
        struct.extra.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TAddLink struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.url = iprot.readString();
      struct.setUrlIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.extra = new TLinkExtra();
        struct.extra.read(iprot);
        struct.setExtraIsSet(true);
      }
    }
  }

}
