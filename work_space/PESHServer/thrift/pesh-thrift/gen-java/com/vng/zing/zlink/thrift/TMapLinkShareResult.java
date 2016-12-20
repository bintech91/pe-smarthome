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

public class TMapLinkShareResult implements org.apache.thrift.TBase<TMapLinkShareResult, TMapLinkShareResult._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TMapLinkShareResult");

  private static final org.apache.thrift.protocol.TField ERROR_FIELD_DESC = new org.apache.thrift.protocol.TField("error", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField MAP_LINK_SHARE_FIELD_DESC = new org.apache.thrift.protocol.TField("mapLinkShare", org.apache.thrift.protocol.TType.MAP, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TMapLinkShareResultStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TMapLinkShareResultTupleSchemeFactory());
  }

  public int error; // required
  public Map<Long,Long> mapLinkShare; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERROR((short)1, "error"),
    MAP_LINK_SHARE((short)2, "mapLinkShare");

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
        case 1: // ERROR
          return ERROR;
        case 2: // MAP_LINK_SHARE
          return MAP_LINK_SHARE;
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
  private static final int __ERROR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.MAP_LINK_SHARE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR, new org.apache.thrift.meta_data.FieldMetaData("error", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.MAP_LINK_SHARE, new org.apache.thrift.meta_data.FieldMetaData("mapLinkShare", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TMapLinkShareResult.class, metaDataMap);
  }

  public TMapLinkShareResult() {
  }

  public TMapLinkShareResult(
    int error)
  {
    this();
    this.error = error;
    setErrorIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TMapLinkShareResult(TMapLinkShareResult other) {
    __isset_bitfield = other.__isset_bitfield;
    this.error = other.error;
    if (other.isSetMapLinkShare()) {
      Map<Long,Long> __this__mapLinkShare = new HashMap<Long,Long>();
      for (Map.Entry<Long, Long> other_element : other.mapLinkShare.entrySet()) {

        Long other_element_key = other_element.getKey();
        Long other_element_value = other_element.getValue();

        Long __this__mapLinkShare_copy_key = other_element_key;

        Long __this__mapLinkShare_copy_value = other_element_value;

        __this__mapLinkShare.put(__this__mapLinkShare_copy_key, __this__mapLinkShare_copy_value);
      }
      this.mapLinkShare = __this__mapLinkShare;
    }
  }

  public TMapLinkShareResult deepCopy() {
    return new TMapLinkShareResult(this);
  }

  @Override
  public void clear() {
    setErrorIsSet(false);
    this.error = 0;
    this.mapLinkShare = null;
  }

  public int getError() {
    return this.error;
  }

  public TMapLinkShareResult setError(int error) {
    this.error = error;
    setErrorIsSet(true);
    return this;
  }

  public void unsetError() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ERROR_ISSET_ID);
  }

  /** Returns true if field error is set (has been assigned a value) and false otherwise */
  public boolean isSetError() {
    return EncodingUtils.testBit(__isset_bitfield, __ERROR_ISSET_ID);
  }

  public void setErrorIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ERROR_ISSET_ID, value);
  }

  public int getMapLinkShareSize() {
    return (this.mapLinkShare == null) ? 0 : this.mapLinkShare.size();
  }

  public void putToMapLinkShare(long key, long val) {
    if (this.mapLinkShare == null) {
      this.mapLinkShare = new HashMap<Long,Long>();
    }
    this.mapLinkShare.put(key, val);
  }

  public Map<Long,Long> getMapLinkShare() {
    return this.mapLinkShare;
  }

  public TMapLinkShareResult setMapLinkShare(Map<Long,Long> mapLinkShare) {
    this.mapLinkShare = mapLinkShare;
    return this;
  }

  public void unsetMapLinkShare() {
    this.mapLinkShare = null;
  }

  /** Returns true if field mapLinkShare is set (has been assigned a value) and false otherwise */
  public boolean isSetMapLinkShare() {
    return this.mapLinkShare != null;
  }

  public void setMapLinkShareIsSet(boolean value) {
    if (!value) {
      this.mapLinkShare = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ERROR:
      if (value == null) {
        unsetError();
      } else {
        setError((Integer)value);
      }
      break;

    case MAP_LINK_SHARE:
      if (value == null) {
        unsetMapLinkShare();
      } else {
        setMapLinkShare((Map<Long,Long>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR:
      return Integer.valueOf(getError());

    case MAP_LINK_SHARE:
      return getMapLinkShare();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ERROR:
      return isSetError();
    case MAP_LINK_SHARE:
      return isSetMapLinkShare();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TMapLinkShareResult)
      return this.equals((TMapLinkShareResult)that);
    return false;
  }

  public boolean equals(TMapLinkShareResult that) {
    if (that == null)
      return false;

    boolean this_present_error = true;
    boolean that_present_error = true;
    if (this_present_error || that_present_error) {
      if (!(this_present_error && that_present_error))
        return false;
      if (this.error != that.error)
        return false;
    }

    boolean this_present_mapLinkShare = true && this.isSetMapLinkShare();
    boolean that_present_mapLinkShare = true && that.isSetMapLinkShare();
    if (this_present_mapLinkShare || that_present_mapLinkShare) {
      if (!(this_present_mapLinkShare && that_present_mapLinkShare))
        return false;
      if (!this.mapLinkShare.equals(that.mapLinkShare))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TMapLinkShareResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TMapLinkShareResult typedOther = (TMapLinkShareResult)other;

    lastComparison = Boolean.valueOf(isSetError()).compareTo(typedOther.isSetError());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetError()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.error, typedOther.error);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMapLinkShare()).compareTo(typedOther.isSetMapLinkShare());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMapLinkShare()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mapLinkShare, typedOther.mapLinkShare);
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
    StringBuilder sb = new StringBuilder("TMapLinkShareResult(");
    boolean first = true;

    sb.append("error:");
    sb.append(this.error);
    first = false;
    if (isSetMapLinkShare()) {
      if (!first) sb.append(", ");
      sb.append("mapLinkShare:");
      if (this.mapLinkShare == null) {
        sb.append("null");
      } else {
        sb.append(this.mapLinkShare);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'error' because it's a primitive and you chose the non-beans generator.
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TMapLinkShareResultStandardSchemeFactory implements SchemeFactory {
    public TMapLinkShareResultStandardScheme getScheme() {
      return new TMapLinkShareResultStandardScheme();
    }
  }

  private static class TMapLinkShareResultStandardScheme extends StandardScheme<TMapLinkShareResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TMapLinkShareResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERROR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.error = iprot.readI32();
              struct.setErrorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAP_LINK_SHARE
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map50 = iprot.readMapBegin();
                struct.mapLinkShare = new HashMap<Long,Long>(2*_map50.size);
                for (int _i51 = 0; _i51 < _map50.size; ++_i51)
                {
                  long _key52; // required
                  long _val53; // required
                  _key52 = iprot.readI64();
                  _val53 = iprot.readI64();
                  struct.mapLinkShare.put(_key52, _val53);
                }
                iprot.readMapEnd();
              }
              struct.setMapLinkShareIsSet(true);
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
      if (!struct.isSetError()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'error' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TMapLinkShareResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERROR_FIELD_DESC);
      oprot.writeI32(struct.error);
      oprot.writeFieldEnd();
      if (struct.mapLinkShare != null) {
        if (struct.isSetMapLinkShare()) {
          oprot.writeFieldBegin(MAP_LINK_SHARE_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.I64, struct.mapLinkShare.size()));
            for (Map.Entry<Long, Long> _iter54 : struct.mapLinkShare.entrySet())
            {
              oprot.writeI64(_iter54.getKey());
              oprot.writeI64(_iter54.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TMapLinkShareResultTupleSchemeFactory implements SchemeFactory {
    public TMapLinkShareResultTupleScheme getScheme() {
      return new TMapLinkShareResultTupleScheme();
    }
  }

  private static class TMapLinkShareResultTupleScheme extends TupleScheme<TMapLinkShareResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TMapLinkShareResult struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.error);
      BitSet optionals = new BitSet();
      if (struct.isSetMapLinkShare()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetMapLinkShare()) {
        {
          oprot.writeI32(struct.mapLinkShare.size());
          for (Map.Entry<Long, Long> _iter55 : struct.mapLinkShare.entrySet())
          {
            oprot.writeI64(_iter55.getKey());
            oprot.writeI64(_iter55.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TMapLinkShareResult struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.error = iprot.readI32();
      struct.setErrorIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TMap _map56 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.I64, org.apache.thrift.protocol.TType.I64, iprot.readI32());
          struct.mapLinkShare = new HashMap<Long,Long>(2*_map56.size);
          for (int _i57 = 0; _i57 < _map56.size; ++_i57)
          {
            long _key58; // required
            long _val59; // required
            _key58 = iprot.readI64();
            _val59 = iprot.readI64();
            struct.mapLinkShare.put(_key58, _val59);
          }
        }
        struct.setMapLinkShareIsSet(true);
      }
    }
  }

}
