/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
#ifndef PESH_PE_SMARTHOME_SHARED_TYPES_H
#define PESH_PE_SMARTHOME_SHARED_TYPES_H

/* base includes */
#include <glib-object.h>
#include <thrift/c_glib/thrift_struct.h>
#include <thrift/c_glib/protocol/thrift_protocol.h>

/* custom thrift includes */

/* begin types */

/* struct helloworld_struct */
struct _peshhelloworld_struct
{ 
  ThriftStruct parent; 

  /* public */
  gint32 test;
  gint32 test_2;
};
typedef struct _peshhelloworld_struct peshhelloworld_struct;

struct _peshhelloworld_structClass
{
  ThriftStructClass parent;
};
typedef struct _peshhelloworld_structClass peshhelloworld_structClass;

GType pesh_helloworld_struct_get_type (void);
#define PESH_TYPE_HELLOWORLD_STRUCT (pesh_helloworld_struct_get_type())
#define PESH_HELLOWORLD_STRUCT(obj) (G_TYPE_CHECK_INSTANCE_CAST ((obj), PESH_TYPE_HELLOWORLD_STRUCT, peshhelloworld_struct))
#define PESH_HELLOWORLD_STRUCT_CLASS(c) (G_TYPE_CHECK_CLASS_CAST ((c), PESH__TYPE_HELLOWORLD_STRUCT, peshhelloworld_structClass))
#define PESH_IS_HELLOWORLD_STRUCT(obj) (G_TYPE_CHECK_INSTANCE_TYPE ((obj), PESH_TYPE_HELLOWORLD_STRUCT))
#define PESH_IS_HELLOWORLD_STRUCT_CLASS(c) (G_TYPE_CHECK_CLASS_TYPE ((c), PESH_TYPE_HELLOWORLD_STRUCT))
#define PESH_HELLOWORLD_STRUCT_GET_CLASS(obj) (G_TYPE_INSTANCE_GET_CLASS ((obj), PESH_TYPE_HELLOWORLD_STRUCT, peshhelloworld_structClass))

/* constants */

#endif /* PESH_PE_SMARTHOME_SHARED_TYPES_H */