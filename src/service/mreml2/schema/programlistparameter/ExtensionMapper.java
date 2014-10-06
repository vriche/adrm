
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */

        
            package mreml2.schema.programlistparameter;
        
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://MREML2/schema/ProgramListParameter".equals(namespaceURI) &&
                  "ImportProgramListResponseType".equals(typeName)){
                   
                            return  mreml2.schema.programlistparameter.ImportProgramListResponseType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramListParameter".equals(namespaceURI) &&
                  "ImportProgramListRequestType".equals(typeName)){
                   
                            return  mreml2.schema.programlistparameter.ImportProgramListRequestType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "SignalSourceType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.SignalSourceType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "BroadcastListItemType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.BroadcastListItemType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/CommonDataType".equals(namespaceURI) &&
                  "ExtendAttributeType".equals(typeName)){
                   
                            return  mreml2.schema.commondatatype.ExtendAttributeType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/CommonDataType".equals(namespaceURI) &&
                  "ExtendAttributesType".equals(typeName)){
                   
                            return  mreml2.schema.commondatatype.ExtendAttributesType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "ExecuteActionType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.ExecuteActionType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "BroadcastListEntityType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.BroadcastListEntityType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/CommonDataType".equals(namespaceURI) &&
                  "CommonRequestType".equals(typeName)){
                   
                            return  mreml2.schema.commondatatype.CommonRequestType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "ChannelInfoType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.ChannelInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "TapeInfoType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.TapeInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/CommonDataType".equals(namespaceURI) &&
                  "CommonResponseType".equals(typeName)){
                   
                            return  mreml2.schema.commondatatype.CommonResponseType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "ColumnInfoType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.ColumnInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://MREML2/schema/ProgramList".equals(namespaceURI) &&
                  "ProgramInfoType".equals(typeName)){
                   
                            return  mreml2.schema.programlist.ProgramInfoType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    