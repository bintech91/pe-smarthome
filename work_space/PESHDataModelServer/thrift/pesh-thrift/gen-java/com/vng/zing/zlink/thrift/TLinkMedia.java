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

public class TLinkMedia implements org.apache.thrift.TBase<TLinkMedia, TLinkMedia._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TLinkMedia");

  private static final org.apache.thrift.protocol.TField MEDIA_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("mediaType", org.apache.thrift.protocol.TType.BYTE, (short)1);
  private static final org.apache.thrift.protocol.TField MEDIA_SOURCE_FIELD_DESC = new org.apache.thrift.protocol.TField("mediaSource", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField MEDIA_IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("mediaImage", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField LARGE_MEDIA_IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("largeMediaImage", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TLinkMediaStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TLinkMediaTupleSchemeFactory());
  }

  public byte mediaType; // optional
  public String mediaSource; // optional
  public String mediaImage; // optional
  public String largeMediaImage; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MEDIA_TYPE((short)1, "mediaType"),
    MEDIA_SOURCE((short)2, "mediaSource"),
    MEDIA_IMAGE((short)3, "mediaImage"),
    LARGE_MEDIA_IMAGE((short)4, "largeMediaImage");

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
        case 1: // MEDIA_TYPE
          return MEDIA_TYPE;
        case 2: // MEDIA_SOURCE
          return MEDIA_SOURCE;
        case 3: // MEDIA_IMAGE
          return MEDIA_IMAGE;
        case 4: // LARGE_MEDIA_IMAGE
          return LARGE_MEDIA_IMAGE;
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
  private static final int __MEDIATYPE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.MEDIA_TYPE,_Fields.MEDIA_SOURCE,_Fields.MEDIA_IMAGE,_Fields.LARGE_MEDIA_IMAGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MEDIA_TYPE, new org.apache.thrift.meta_data.FieldMetaData("mediaType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.MEDIA_SOURCE, new org.apache.thrift.meta_data.FieldMetaData("mediaSource", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MEDIA_IMAGE, new org.apache.thrift.meta_data.FieldMetaData("mediaImage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LARGE_MEDIA_IMAGE, new org.apache.thrift.meta_data.FieldMetaData("largeMediaImage", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TLinkMedia.class, metaDataMap);
  }

  public TLinkMedia() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TLinkMedia(TLinkMedia other) {
    __isset_bitfield = other.__isset_bitfield;
    this.mediaType = other.mediaType;
    if (other.isSetMediaSource()) {
      this.mediaSource = other.mediaSource;
    }
    if (other.isSetMediaImage()) {
      this.mediaImage = other.mediaImage;
    }
    if (other.isSetLargeMediaImage()) {
      this.largeMediaImage = other.largeMediaImage;
    }
  }

  public TLinkMedia deepCopy() {
    return new TLinkMedia(this);
  }

  @Override
  public void clear() {
    setMediaTypeIsSet(false);
    this.mediaType = 0;
    this.mediaSource = null;
    this.mediaImage = null;
    this.largeMediaImage = null;
  }

  public byte getMediaType() {
    return this.mediaType;
  }

  public TLinkMedia setMediaType(byte mediaType) {
    this.mediaType = mediaType;
    setMediaTypeIsSet(true);
    return this;
  }

  public void unsetMediaType() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MEDIATYPE_ISSET_ID);
  }

  /** Returns true if field mediaType is set (has been assigned a value) and false otherwise */
  public boolean isSetMediaType() {
    return EncodingUtils.testBit(__isset_bitfield, __MEDIATYPE_ISSET_ID);
  }

  public void setMediaTypeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MEDIATYPE_ISSET_ID, value);
  }

  public String getMediaSource() {
    return this.mediaSource;
  }

  public TLinkMedia setMediaSource(String mediaSource) {
    this.mediaSource = mediaSource;
    return this;
  }

  public void unsetMediaSource() {
    this.mediaSource = null;
  }

  /** Returns true if field mediaSource is set (has been assigned a value) and false otherwise */
  public boolean isSetMediaSource() {
    return this.mediaSource != null;
  }

  public void setMediaSourceIsSet(boolean value) {
    if (!value) {
      this.mediaSource = null;
    }
  }

  public String getMediaImage() {
    return this.mediaImage;
  }

  public TLinkMedia setMediaImage(String mediaImage) {
    this.mediaImage = mediaImage;
    return this;
  }

  public void unsetMediaImage() {
    this.mediaImage = null;
  }

  /** Returns true if field mediaImage is set (has been assigned a value) and false otherwise */
  public boolean isSetMediaImage() {
    return this.mediaImage != null;
  }

  public void setMediaImageIsSet(boolean value) {
    if (!value) {
      this.mediaImage = null;
    }
  }

  public String getLargeMediaImage() {
    return this.largeMediaImage;
  }

  public TLinkMedia setLargeMediaImage(String largeMediaImage) {
    this.largeMediaImage = largeMediaImage;
    return this;
  }

  public void unsetLargeMediaImage() {
    this.largeMediaImage = null;
  }

  /** Returns true if field largeMediaImage is set (has been assigned a value) and false otherwise */
  public boolean isSetLargeMediaImage() {
    return this.largeMediaImage != null;
  }

  public void setLargeMediaImageIsSet(boolean value) {
    if (!value) {
      this.largeMediaImage = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case MEDIA_TYPE:
      if (value == null) {
        unsetMediaType();
      } else {
        setMediaType((Byte)value);
      }
      break;

    case MEDIA_SOURCE:
      if (value == null) {
        unsetMediaSource();
      } else {
        setMediaSource((String)value);
      }
      break;

    case MEDIA_IMAGE:
      if (value == null) {
        unsetMediaImage();
      } else {
        setMediaImage((String)value);
      }
      break;

    case LARGE_MEDIA_IMAGE:
      if (value == null) {
        unsetLargeMediaImage();
      } else {
        setLargeMediaImage((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MEDIA_TYPE:
      return Byte.valueOf(getMediaType());

    case MEDIA_SOURCE:
      return getMediaSource();

    case MEDIA_IMAGE:
      return getMediaImage();

    case LARGE_MEDIA_IMAGE:
      return getLargeMediaImage();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MEDIA_TYPE:
      return isSetMediaType();
    case MEDIA_SOURCE:
      return isSetMediaSource();
    case MEDIA_IMAGE:
      return isSetMediaImage();
    case LARGE_MEDIA_IMAGE:
      return isSetLargeMediaImage();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TLinkMedia)
      return this.equals((TLinkMedia)that);
    return false;
  }

  public boolean equals(TLinkMedia that) {
    if (that == null)
      return false;

    boolean this_present_mediaType = true && this.isSetMediaType();
    boolean that_present_mediaType = true && that.isSetMediaType();
    if (this_present_mediaType || that_present_mediaType) {
      if (!(this_present_mediaType && that_present_mediaType))
        return false;
      if (this.mediaType != that.mediaType)
        return false;
    }

    boolean this_present_mediaSource = true && this.isSetMediaSource();
    boolean that_present_mediaSource = true && that.isSetMediaSource();
    if (this_present_mediaSource || that_present_mediaSource) {
      if (!(this_present_mediaSource && that_present_mediaSource))
        return false;
      if (!this.mediaSource.equals(that.mediaSource))
        return false;
    }

    boolean this_present_mediaImage = true && this.isSetMediaImage();
    boolean that_present_mediaImage = true && that.isSetMediaImage();
    if (this_present_mediaImage || that_present_mediaImage) {
      if (!(this_present_mediaImage && that_present_mediaImage))
        return false;
      if (!this.mediaImage.equals(that.mediaImage))
        return false;
    }

    boolean this_present_largeMediaImage = true && this.isSetLargeMediaImage();
    boolean that_present_largeMediaImage = true && that.isSetLargeMediaImage();
    if (this_present_largeMediaImage || that_present_largeMediaImage) {
      if (!(this_present_largeMediaImage && that_present_largeMediaImage))
        return false;
      if (!this.largeMediaImage.equals(that.largeMediaImage))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(TLinkMedia other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TLinkMedia typedOther = (TLinkMedia)other;

    lastComparison = Boolean.valueOf(isSetMediaType()).compareTo(typedOther.isSetMediaType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMediaType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mediaType, typedOther.mediaType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMediaSource()).compareTo(typedOther.isSetMediaSource());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMediaSource()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mediaSource, typedOther.mediaSource);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMediaImage()).compareTo(typedOther.isSetMediaImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMediaImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.mediaImage, typedOther.mediaImage);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLargeMediaImage()).compareTo(typedOther.isSetLargeMediaImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLargeMediaImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.largeMediaImage, typedOther.largeMediaImage);
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
    StringBuilder sb = new StringBuilder("TLinkMedia(");
    boolean first = true;

    if (isSetMediaType()) {
      sb.append("mediaType:");
      sb.append(this.mediaType);
      first = false;
    }
    if (isSetMediaSource()) {
      if (!first) sb.append(", ");
      sb.append("mediaSource:");
      if (this.mediaSource == null) {
        sb.append("null");
      } else {
        sb.append(this.mediaSource);
      }
      first = false;
    }
    if (isSetMediaImage()) {
      if (!first) sb.append(", ");
      sb.append("mediaImage:");
      if (this.mediaImage == null) {
        sb.append("null");
      } else {
        sb.append(this.mediaImage);
      }
      first = false;
    }
    if (isSetLargeMediaImage()) {
      if (!first) sb.append(", ");
      sb.append("largeMediaImage:");
      if (this.largeMediaImage == null) {
        sb.append("null");
      } else {
        sb.append(this.largeMediaImage);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TLinkMediaStandardSchemeFactory implements SchemeFactory {
    public TLinkMediaStandardScheme getScheme() {
      return new TLinkMediaStandardScheme();
    }
  }

  private static class TLinkMediaStandardScheme extends StandardScheme<TLinkMedia> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TLinkMedia struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MEDIA_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.mediaType = iprot.readByte();
              struct.setMediaTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MEDIA_SOURCE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mediaSource = iprot.readString();
              struct.setMediaSourceIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEDIA_IMAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.mediaImage = iprot.readString();
              struct.setMediaImageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // LARGE_MEDIA_IMAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.largeMediaImage = iprot.readString();
              struct.setLargeMediaImageIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TLinkMedia struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetMediaType()) {
        oprot.writeFieldBegin(MEDIA_TYPE_FIELD_DESC);
        oprot.writeByte(struct.mediaType);
        oprot.writeFieldEnd();
      }
      if (struct.mediaSource != null) {
        if (struct.isSetMediaSource()) {
          oprot.writeFieldBegin(MEDIA_SOURCE_FIELD_DESC);
          oprot.writeString(struct.mediaSource);
          oprot.writeFieldEnd();
        }
      }
      if (struct.mediaImage != null) {
        if (struct.isSetMediaImage()) {
          oprot.writeFieldBegin(MEDIA_IMAGE_FIELD_DESC);
          oprot.writeString(struct.mediaImage);
          oprot.writeFieldEnd();
        }
      }
      if (struct.largeMediaImage != null) {
        if (struct.isSetLargeMediaImage()) {
          oprot.writeFieldBegin(LARGE_MEDIA_IMAGE_FIELD_DESC);
          oprot.writeString(struct.largeMediaImage);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TLinkMediaTupleSchemeFactory implements SchemeFactory {
    public TLinkMediaTupleScheme getScheme() {
      return new TLinkMediaTupleScheme();
    }
  }

  private static class TLinkMediaTupleScheme extends TupleScheme<TLinkMedia> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TLinkMedia struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetMediaType()) {
        optionals.set(0);
      }
      if (struct.isSetMediaSource()) {
        optionals.set(1);
      }
      if (struct.isSetMediaImage()) {
        optionals.set(2);
      }
      if (struct.isSetLargeMediaImage()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetMediaType()) {
        oprot.writeByte(struct.mediaType);
      }
      if (struct.isSetMediaSource()) {
        oprot.writeString(struct.mediaSource);
      }
      if (struct.isSetMediaImage()) {
        oprot.writeString(struct.mediaImage);
      }
      if (struct.isSetLargeMediaImage()) {
        oprot.writeString(struct.largeMediaImage);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TLinkMedia struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.mediaType = iprot.readByte();
        struct.setMediaTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.mediaSource = iprot.readString();
        struct.setMediaSourceIsSet(true);
      }
      if (incoming.get(2)) {
        struct.mediaImage = iprot.readString();
        struct.setMediaImageIsSet(true);
      }
      if (incoming.get(3)) {
        struct.largeMediaImage = iprot.readString();
        struct.setLargeMediaImageIsSet(true);
      }
    }
  }

}
