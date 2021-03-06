/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

#include "pesh_pe_smarthome_shared_types.h"
#include <thrift/c_glib/thrift.h>

/* reads a helloworld_struct object */
static gint32
pesh_helloworld_struct_read (ThriftStruct *object, ThriftProtocol *protocol, GError **error)
{
  gint32 ret;
  gint32 xfer = 0;
  gchar *name = NULL;
  ThriftType ftype;
  gint16 fid;
  guint32 len = 0;
  gpointer data = NULL;
  peshhelloworld_struct * this_object = PESH_HELLOWORLD_STRUCT(object);
  gboolean isset_test = FALSE;
  gboolean isset_test_2 = FALSE;

  /* satisfy -Wall in case these aren't used */
  THRIFT_UNUSED_VAR (len);
  THRIFT_UNUSED_VAR (data);
  THRIFT_UNUSED_VAR (this_object);

  /* read the struct begin marker */
  if ((ret = thrift_protocol_read_struct_begin (protocol, &name, error)) < 0)
  {
    if (name) g_free (name);
    return -1;
  }
  xfer += ret;
  if (name) g_free (name);
  name = NULL;

  /* read the struct fields */
  while (1)
  {
    /* read the beginning of a field */
    if ((ret = thrift_protocol_read_field_begin (protocol, &name, &ftype, &fid, error)) < 0)
    {
      if (name) g_free (name);
      return -1;
    }
    xfer += ret;
    if (name) g_free (name);
    name = NULL;

    /* break if we get a STOP field */
    if (ftype == T_STOP)
    {
      break;
    }

    switch (fid)
    {
      case 1:
        if (ftype == T_I32)
        {
          if ((ret = thrift_protocol_read_i32 (protocol, &this_object->test, error)) < 0)
            return -1;
          xfer += ret;
          isset_test = TRUE;
        } else {
          if ((ret = thrift_protocol_skip (protocol, ftype, error)) < 0)
            return -1;
          xfer += ret;
        }
        break;
      case 2:
        if (ftype == T_I32)
        {
          if ((ret = thrift_protocol_read_i32 (protocol, &this_object->test_2, error)) < 0)
            return -1;
          xfer += ret;
          isset_test_2 = TRUE;
        } else {
          if ((ret = thrift_protocol_skip (protocol, ftype, error)) < 0)
            return -1;
          xfer += ret;
        }
        break;
      default:
        if ((ret = thrift_protocol_skip (protocol, ftype, error)) < 0)
          return -1;
        xfer += ret;
        break;
    }
    if ((ret = thrift_protocol_read_field_end (protocol, error)) < 0)
      return -1;
    xfer += ret;
  }

  if ((ret = thrift_protocol_read_struct_end (protocol, error)) < 0)
    return -1;
  xfer += ret;

  if (!isset_test)
  {
    g_set_error (error, THRIFT_PROTOCOL_ERROR,
                 THRIFT_PROTOCOL_ERROR_INVALID_DATA,
                 "missing field");
    return -1;
  }

  if (!isset_test_2)
  {
    g_set_error (error, THRIFT_PROTOCOL_ERROR,
                 THRIFT_PROTOCOL_ERROR_INVALID_DATA,
                 "missing field");
    return -1;
  }

  return xfer;
}

static gint32
pesh_helloworld_struct_write (ThriftStruct *object, ThriftProtocol *protocol, GError **error)
{
  gint32 ret;
  gint32 xfer = 0;

  peshhelloworld_struct * this_object = PESH_HELLOWORLD_STRUCT(object);
  THRIFT_UNUSED_VAR (this_object);
  if ((ret = thrift_protocol_write_struct_begin (protocol, "helloworld_struct", error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_field_begin (protocol, "test", T_I32, 1, error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_i32 (protocol, this_object->test, error)) < 0)
    return -1;
  if ((ret = thrift_protocol_write_field_end (protocol, error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_field_begin (protocol, "test_2", T_I32, 2, error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_i32 (protocol, this_object->test_2, error)) < 0)
    return -1;
  if ((ret = thrift_protocol_write_field_end (protocol, error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_field_stop (protocol, error)) < 0)
    return -1;
  xfer += ret;
  if ((ret = thrift_protocol_write_struct_end (protocol, error)) < 0)
    return -1;
  xfer += ret;

  return xfer;
}

static void 
pesh_helloworld_struct_instance_init (peshhelloworld_struct * object)
{
  /* satisfy -Wall */
  THRIFT_UNUSED_VAR (object);
  object->test = 0;
  object->test_2 = 0;
}

static void 
pesh_helloworld_struct_finalize (GObject *object)
{
  peshhelloworld_struct *tobject = PESH_HELLOWORLD_STRUCT (object);

  /* satisfy -Wall in case we don't use tobject */
  THRIFT_UNUSED_VAR (tobject);
}

static void 
pesh_helloworld_struct_class_init (ThriftStructClass * cls)
{
  GObjectClass *gobject_class = G_OBJECT_CLASS (cls);

  gobject_class->finalize = pesh_helloworld_struct_finalize;
  cls->read = pesh_helloworld_struct_read;
  cls->write = pesh_helloworld_struct_write;
}

GType
pesh_helloworld_struct_get_type (void)
{
  static GType type = 0;

  if (type == 0) 
  {
    static const GTypeInfo type_info = 
    {
      sizeof (peshhelloworld_structClass),
      NULL, /* base_init */
      NULL, /* base_finalize */
      (GClassInitFunc) pesh_helloworld_struct_class_init,
      NULL, /* class_finalize */
      NULL, /* class_data */
      sizeof (peshhelloworld_struct),
      0, /* n_preallocs */
      (GInstanceInitFunc) pesh_helloworld_struct_instance_init,
      NULL, /* value_table */
    };

    type = g_type_register_static (THRIFT_TYPE_STRUCT, 
                                   "peshhelloworld_structType",
                                   &type_info, 0);
  }

  return type;
}

/* constants */

