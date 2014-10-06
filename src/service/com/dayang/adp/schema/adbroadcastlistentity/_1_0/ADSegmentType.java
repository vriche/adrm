
/**
 * ADSegmentType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */
            
                package com.dayang.adp.schema.adbroadcastlistentity._1_0;
            

            /**
            *  ADSegmentType bean class
            */
        
        public  class ADSegmentType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ADSegmentType
                Namespace URI = http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0
                Namespace Prefix = ns4
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0")){
                return "ns4";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for SegmentID
                        */

                        
                                    protected java.lang.String localSegmentID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSegmentID(){
                               return localSegmentID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SegmentID
                               */
                               public void setSegmentID(java.lang.String param){
                            
                                            this.localSegmentID=param;
                                    

                               }
                            

                        /**
                        * field for SegmentBusinessID
                        */

                        
                                    protected java.lang.String localSegmentBusinessID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSegmentBusinessID(){
                               return localSegmentBusinessID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SegmentBusinessID
                               */
                               public void setSegmentBusinessID(java.lang.String param){
                            
                                            this.localSegmentBusinessID=param;
                                    

                               }
                            

                        /**
                        * field for SegmentName
                        */

                        
                                    protected java.lang.String localSegmentName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSegmentName(){
                               return localSegmentName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SegmentName
                               */
                               public void setSegmentName(java.lang.String param){
                            
                                            this.localSegmentName=param;
                                    

                               }
                            

                        /**
                        * field for SegmentType
                        */

                        
                                    protected int localSegmentType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSegmentTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getSegmentType(){
                               return localSegmentType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SegmentType
                               */
                               public void setSegmentType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localSegmentTypeTracker = false;
                                              
                                       } else {
                                          localSegmentTypeTracker = true;
                                       }
                                   
                                            this.localSegmentType=param;
                                    

                               }
                            

                        /**
                        * field for SegmentIndex
                        */

                        
                                    protected int localSegmentIndex ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getSegmentIndex(){
                               return localSegmentIndex;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SegmentIndex
                               */
                               public void setSegmentIndex(int param){
                            
                                            this.localSegmentIndex=param;
                                    

                               }
                            

                        /**
                        * field for PlayTime
                        */

                        
                                    protected java.lang.String localPlayTime ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPlayTime(){
                               return localPlayTime;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PlayTime
                               */
                               public void setPlayTime(java.lang.String param){
                            
                                            this.localPlayTime=param;
                                    

                               }
                            

                        /**
                        * field for ColumnCode
                        */

                        
                                    protected java.lang.String localColumnCode ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localColumnCodeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getColumnCode(){
                               return localColumnCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ColumnCode
                               */
                               public void setColumnCode(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localColumnCodeTracker = true;
                                       } else {
                                          localColumnCodeTracker = false;
                                              
                                       }
                                   
                                            this.localColumnCode=param;
                                    

                               }
                            

                        /**
                        * field for ColumnName
                        */

                        
                                    protected java.lang.String localColumnName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localColumnNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getColumnName(){
                               return localColumnName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ColumnName
                               */
                               public void setColumnName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localColumnNameTracker = true;
                                       } else {
                                          localColumnNameTracker = false;
                                              
                                       }
                                   
                                            this.localColumnName=param;
                                    

                               }
                            

                        /**
                        * field for Duration
                        */

                        
                                    protected int localDuration ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getDuration(){
                               return localDuration;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Duration
                               */
                               public void setDuration(int param){
                            
                                            this.localDuration=param;
                                    

                               }
                            

                        /**
                        * field for PlayPattern
                        */

                        
                                    protected int localPlayPattern ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPlayPattern(){
                               return localPlayPattern;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PlayPattern
                               */
                               public void setPlayPattern(int param){
                            
                                            this.localPlayPattern=param;
                                    

                               }
                            

                        /**
                        * field for StudioName
                        */

                        
                                    protected java.lang.String localStudioName ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStudioNameTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getStudioName(){
                               return localStudioName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param StudioName
                               */
                               public void setStudioName(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localStudioNameTracker = true;
                                       } else {
                                          localStudioNameTracker = false;
                                              
                                       }
                                   
                                            this.localStudioName=param;
                                    

                               }
                            

                        /**
                        * field for ADEntity
                        * This was an Array!
                        */

                        
                                    protected com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[] localADEntity ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localADEntityTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[]
                           */
                           public  com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[] getADEntity(){
                               return localADEntity;
                           }

                           
                        


                               
                              /**
                               * validate the array for ADEntity
                               */
                              protected void validateADEntity(com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param ADEntity
                              */
                              public void setADEntity(com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[] param){
                              
                                   validateADEntity(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localADEntityTracker = true;
                                          } else {
                                             localADEntityTracker = false;
                                                 
                                          }
                                      
                                      this.localADEntity=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType
                             */
                             public void addADEntity(com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType param){
                                   if (localADEntity == null){
                                   localADEntity = new com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[]{};
                                   }

                            
                                 //update the setting tracker
                                localADEntityTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localADEntity);
                               list.add(param);
                               this.localADEntity =
                             (com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[])list.toArray(
                            new com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[list.size()]);

                             }
                             

                        /**
                        * field for ExtendAttributes
                        */

                        
                                    protected com.dayang.adp.schema.adbroadcastlistentity._1_0.ExtendAttributesType localExtendAttributes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExtendAttributesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adbroadcastlistentity._1_0.ExtendAttributesType
                           */
                           public  com.dayang.adp.schema.adbroadcastlistentity._1_0.ExtendAttributesType getExtendAttributes(){
                               return localExtendAttributes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExtendAttributes
                               */
                               public void setExtendAttributes(com.dayang.adp.schema.adbroadcastlistentity._1_0.ExtendAttributesType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localExtendAttributesTracker = true;
                                       } else {
                                          localExtendAttributesTracker = false;
                                              
                                       }
                                   
                                            this.localExtendAttributes=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ADSegmentType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ADSegmentType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ADSegmentType",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SegmentID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SegmentID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SegmentID");
                                    }
                                

                                          if (localSegmentID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SegmentID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSegmentID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SegmentBusinessID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SegmentBusinessID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SegmentBusinessID");
                                    }
                                

                                          if (localSegmentBusinessID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SegmentBusinessID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSegmentBusinessID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SegmentName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SegmentName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SegmentName");
                                    }
                                

                                          if (localSegmentName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("SegmentName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSegmentName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localSegmentTypeTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SegmentType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SegmentType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SegmentType");
                                    }
                                
                                               if (localSegmentType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("SegmentType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SegmentIndex", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SegmentIndex");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SegmentIndex");
                                    }
                                
                                               if (localSegmentIndex==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("SegmentIndex cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentIndex));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PlayTime", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PlayTime");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PlayTime");
                                    }
                                

                                          if (localPlayTime==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PlayTime cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPlayTime);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localColumnCodeTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ColumnCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ColumnCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ColumnCode");
                                    }
                                

                                          if (localColumnCode==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ColumnCode cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localColumnCode);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localColumnNameTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"ColumnName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"ColumnName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("ColumnName");
                                    }
                                

                                          if (localColumnName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ColumnName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localColumnName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Duration", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Duration");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Duration");
                                    }
                                
                                               if (localDuration==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Duration cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDuration));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PlayPattern", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PlayPattern");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PlayPattern");
                                    }
                                
                                               if (localPlayPattern==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("PlayPattern cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPlayPattern));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localStudioNameTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"StudioName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"StudioName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("StudioName");
                                    }
                                

                                          if (localStudioName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("StudioName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localStudioName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localADEntityTracker){
                                       if (localADEntity!=null){
                                            for (int i = 0;i < localADEntity.length;i++){
                                                if (localADEntity[i] != null){
                                                 localADEntity[i].serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ADEntity"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("ADEntity cannot be null!!");
                                        
                                    }
                                 } if (localExtendAttributesTracker){
                                            if (localExtendAttributes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ExtendAttributes cannot be null!!");
                                            }
                                           localExtendAttributes.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ExtendAttributes"),
                                               factory,xmlWriter);
                                        }
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "SegmentID"));
                                 
                                        if (localSegmentID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SegmentID cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "SegmentBusinessID"));
                                 
                                        if (localSegmentBusinessID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentBusinessID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SegmentBusinessID cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "SegmentName"));
                                 
                                        if (localSegmentName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("SegmentName cannot be null!!");
                                        }
                                     if (localSegmentTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "SegmentType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentType));
                            }
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "SegmentIndex"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSegmentIndex));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "PlayTime"));
                                 
                                        if (localPlayTime != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPlayTime));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("PlayTime cannot be null!!");
                                        }
                                     if (localColumnCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "ColumnCode"));
                                 
                                        if (localColumnCode != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localColumnCode));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ColumnCode cannot be null!!");
                                        }
                                    } if (localColumnNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "ColumnName"));
                                 
                                        if (localColumnName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localColumnName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ColumnName cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "Duration"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDuration));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "PlayPattern"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPlayPattern));
                             if (localStudioNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "StudioName"));
                                 
                                        if (localStudioName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStudioName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("StudioName cannot be null!!");
                                        }
                                    } if (localADEntityTracker){
                             if (localADEntity!=null) {
                                 for (int i = 0;i < localADEntity.length;i++){

                                    if (localADEntity[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                          "ADEntity"));
                                         elementList.add(localADEntity[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("ADEntity cannot be null!!");
                                    
                             }

                        } if (localExtendAttributesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0",
                                                                      "ExtendAttributes"));
                            
                            
                                    if (localExtendAttributes==null){
                                         throw new org.apache.axis2.databinding.ADBException("ExtendAttributes cannot be null!!");
                                    }
                                    elementList.add(localExtendAttributes);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ADSegmentType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ADSegmentType object =
                new ADSegmentType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"ADSegmentType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ADSegmentType)com.dayang.adp.schema.adfileinfoentity._1_0.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list12 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","SegmentID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSegmentID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","SegmentBusinessID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSegmentBusinessID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","SegmentName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSegmentName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","SegmentType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSegmentType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setSegmentType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","SegmentIndex").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSegmentIndex(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","PlayTime").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPlayTime(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ColumnCode").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setColumnCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ColumnName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setColumnName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","Duration").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDuration(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","PlayPattern").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPlayPattern(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","StudioName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStudioName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ADEntity").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list12.add(com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone12 = false;
                                                        while(!loopDone12){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone12 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ADEntity").equals(reader.getName())){
                                                                    list12.add(com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone12 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setADEntity((com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.dayang.adp.schema.adbroadcastlistentity._1_0.ADEntityType.class,
                                                                list12));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADBroadcastListEntity/1.0","ExtendAttributes").equals(reader.getName())){
                                
                                                object.setExtendAttributes(com.dayang.adp.schema.adbroadcastlistentity._1_0.ExtendAttributesType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          