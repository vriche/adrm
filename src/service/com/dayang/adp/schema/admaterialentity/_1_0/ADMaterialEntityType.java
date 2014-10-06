
/**
 * ADMaterialEntityType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */
            
                package com.dayang.adp.schema.admaterialentity._1_0;
            

            /**
            *  ADMaterialEntityType bean class
            */
        
        public  class ADMaterialEntityType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ADMaterialEntityType
                Namespace URI = http://dayang.com/ADP/schema/ADMaterialEntity/1.0
                Namespace Prefix = ns5
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dayang.com/ADP/schema/ADMaterialEntity/1.0")){
                return "ns5";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for MaterialID
                        */

                        
                                    protected java.lang.String localMaterialID ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMaterialID(){
                               return localMaterialID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaterialID
                               */
                               public void setMaterialID(java.lang.String param){
                            
                                            this.localMaterialID=param;
                                    

                               }
                            

                        /**
                        * field for MaterialName
                        */

                        
                                    protected java.lang.String localMaterialName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMaterialName(){
                               return localMaterialName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaterialName
                               */
                               public void setMaterialName(java.lang.String param){
                            
                                            this.localMaterialName=param;
                                    

                               }
                            

                        /**
                        * field for MaterialType
                        */

                        
                                    protected int localMaterialType ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMaterialType(){
                               return localMaterialType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MaterialType
                               */
                               public void setMaterialType(int param){
                            
                                            this.localMaterialType=param;
                                    

                               }
                            

                        /**
                        * field for MediumType
                        */

                        
                                    protected int localMediumType =
                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt("1");
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMediumType(){
                               return localMediumType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MediumType
                               */
                               public void setMediumType(int param){
                            
                                            this.localMediumType=param;
                                    

                               }
                            

                        /**
                        * field for Standard
                        */

                        
                                    protected int localStandard ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getStandard(){
                               return localStandard;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Standard
                               */
                               public void setStandard(int param){
                            
                                            this.localStandard=param;
                                    

                               }
                            

                        /**
                        * field for TotalLength
                        */

                        
                                    protected int localTotalLength ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTotalLength(){
                               return localTotalLength;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TotalLength
                               */
                               public void setTotalLength(int param){
                            
                                            this.localTotalLength=param;
                                    

                               }
                            

                        /**
                        * field for MarkIn
                        */

                        
                                    protected int localMarkIn ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMarkInTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMarkIn(){
                               return localMarkIn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MarkIn
                               */
                               public void setMarkIn(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localMarkInTracker = false;
                                              
                                       } else {
                                          localMarkInTracker = true;
                                       }
                                   
                                            this.localMarkIn=param;
                                    

                               }
                            

                        /**
                        * field for MarkOut
                        */

                        
                                    protected int localMarkOut ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMarkOutTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMarkOut(){
                               return localMarkOut;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MarkOut
                               */
                               public void setMarkOut(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localMarkOutTracker = false;
                                              
                                       } else {
                                          localMarkOutTracker = true;
                                       }
                                   
                                            this.localMarkOut=param;
                                    

                               }
                            

                        /**
                        * field for HDFlag
                        */

                        
                                    protected int localHDFlag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHDFlagTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getHDFlag(){
                               return localHDFlag;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param HDFlag
                               */
                               public void setHDFlag(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localHDFlagTracker = false;
                                              
                                       } else {
                                          localHDFlagTracker = true;
                                       }
                                   
                                            this.localHDFlag=param;
                                    

                               }
                            

                        /**
                        * field for AFD
                        */

                        
                                    protected java.lang.String localAFD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAFDTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAFD(){
                               return localAFD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AFD
                               */
                               public void setAFD(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localAFDTracker = true;
                                       } else {
                                          localAFDTracker = false;
                                              
                                       }
                                   
                                            this.localAFD=param;
                                    

                               }
                            

                        /**
                        * field for BusinessType
                        */

                        
                                    protected int localBusinessType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBusinessTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getBusinessType(){
                               return localBusinessType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BusinessType
                               */
                               public void setBusinessType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localBusinessTypeTracker = false;
                                              
                                       } else {
                                          localBusinessTypeTracker = true;
                                       }
                                   
                                            this.localBusinessType=param;
                                    

                               }
                            

                        /**
                        * field for SubBusinessType
                        */

                        
                                    protected int localSubBusinessType ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubBusinessTypeTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getSubBusinessType(){
                               return localSubBusinessType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SubBusinessType
                               */
                               public void setSubBusinessType(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localSubBusinessTypeTracker = false;
                                              
                                       } else {
                                          localSubBusinessTypeTracker = true;
                                       }
                                   
                                            this.localSubBusinessType=param;
                                    

                               }
                            

                        /**
                        * field for PrePlayColumn
                        */

                        
                                    protected java.lang.String localPrePlayColumn ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrePlayColumnTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPrePlayColumn(){
                               return localPrePlayColumn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrePlayColumn
                               */
                               public void setPrePlayColumn(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPrePlayColumnTracker = true;
                                       } else {
                                          localPrePlayColumnTracker = false;
                                              
                                       }
                                   
                                            this.localPrePlayColumn=param;
                                    

                               }
                            

                        /**
                        * field for PrePlayChannel
                        */

                        
                                    protected java.lang.String localPrePlayChannel ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrePlayChannelTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPrePlayChannel(){
                               return localPrePlayChannel;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PrePlayChannel
                               */
                               public void setPrePlayChannel(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localPrePlayChannelTracker = true;
                                       } else {
                                          localPrePlayChannelTracker = false;
                                              
                                       }
                                   
                                            this.localPrePlayChannel=param;
                                    

                               }
                            

                        /**
                        * field for Description
                        */

                        
                                    protected java.lang.String localDescription ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescriptionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescription(){
                               return localDescription;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Description
                               */
                               public void setDescription(java.lang.String param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localDescriptionTracker = true;
                                       } else {
                                          localDescriptionTracker = false;
                                              
                                       }
                                   
                                            this.localDescription=param;
                                    

                               }
                            

                        /**
                        * field for ExtendAttributes
                        */

                        
                                    protected com.dayang.adp.schema.admaterialentity._1_0.ExtendAttributesTypeE localExtendAttributes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExtendAttributesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.admaterialentity._1_0.ExtendAttributesTypeE
                           */
                           public  com.dayang.adp.schema.admaterialentity._1_0.ExtendAttributesTypeE getExtendAttributes(){
                               return localExtendAttributes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExtendAttributes
                               */
                               public void setExtendAttributes(com.dayang.adp.schema.admaterialentity._1_0.ExtendAttributesTypeE param){
                            
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
                       ADMaterialEntityType.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dayang.com/ADP/schema/ADMaterialEntity/1.0");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ADMaterialEntityType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ADMaterialEntityType",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MaterialID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MaterialID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MaterialID");
                                    }
                                

                                          if (localMaterialID==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MaterialID cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMaterialID);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MaterialName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MaterialName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MaterialName");
                                    }
                                

                                          if (localMaterialName==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("MaterialName cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMaterialName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MaterialType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MaterialType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MaterialType");
                                    }
                                
                                               if (localMaterialType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MaterialType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaterialType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MediumType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MediumType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MediumType");
                                    }
                                
                                               if (localMediumType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MediumType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMediumType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Standard", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Standard");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Standard");
                                    }
                                
                                               if (localStandard==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("Standard cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStandard));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"TotalLength", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"TotalLength");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("TotalLength");
                                    }
                                
                                               if (localTotalLength==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("TotalLength cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalLength));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localMarkInTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MarkIn", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MarkIn");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MarkIn");
                                    }
                                
                                               if (localMarkIn==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MarkIn cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMarkIn));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMarkOutTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"MarkOut", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"MarkOut");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("MarkOut");
                                    }
                                
                                               if (localMarkOut==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("MarkOut cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMarkOut));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHDFlagTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"HDFlag", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"HDFlag");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("HDFlag");
                                    }
                                
                                               if (localHDFlag==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("HDFlag cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHDFlag));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localAFDTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"AFD", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"AFD");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("AFD");
                                    }
                                

                                          if (localAFD==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("AFD cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAFD);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localBusinessTypeTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"BusinessType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"BusinessType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("BusinessType");
                                    }
                                
                                               if (localBusinessType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("BusinessType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusinessType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSubBusinessTypeTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"SubBusinessType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"SubBusinessType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("SubBusinessType");
                                    }
                                
                                               if (localSubBusinessType==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("SubBusinessType cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubBusinessType));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrePlayColumnTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PrePlayColumn", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PrePlayColumn");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PrePlayColumn");
                                    }
                                

                                          if (localPrePlayColumn==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PrePlayColumn cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPrePlayColumn);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrePlayChannelTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"PrePlayChannel", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"PrePlayChannel");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("PrePlayChannel");
                                    }
                                

                                          if (localPrePlayChannel==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("PrePlayChannel cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPrePlayChannel);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDescriptionTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADMaterialEntity/1.0";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Description", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Description");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Description");
                                    }
                                

                                          if (localDescription==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("Description cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDescription);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExtendAttributesTracker){
                                            if (localExtendAttributes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ExtendAttributes cannot be null!!");
                                            }
                                           localExtendAttributes.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","ExtendAttributes"),
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

                
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MaterialID"));
                                 
                                        if (localMaterialID != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaterialID));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MaterialID cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MaterialName"));
                                 
                                        if (localMaterialName != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaterialName));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("MaterialName cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MaterialType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMaterialType));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MediumType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMediumType));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "Standard"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStandard));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "TotalLength"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTotalLength));
                             if (localMarkInTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MarkIn"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMarkIn));
                            } if (localMarkOutTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "MarkOut"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMarkOut));
                            } if (localHDFlagTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "HDFlag"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHDFlag));
                            } if (localAFDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "AFD"));
                                 
                                        if (localAFD != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAFD));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("AFD cannot be null!!");
                                        }
                                    } if (localBusinessTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "BusinessType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusinessType));
                            } if (localSubBusinessTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "SubBusinessType"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSubBusinessType));
                            } if (localPrePlayColumnTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "PrePlayColumn"));
                                 
                                        if (localPrePlayColumn != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrePlayColumn));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("PrePlayColumn cannot be null!!");
                                        }
                                    } if (localPrePlayChannelTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "PrePlayChannel"));
                                 
                                        if (localPrePlayChannel != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrePlayChannel));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("PrePlayChannel cannot be null!!");
                                        }
                                    } if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
                                                                      "Description"));
                                 
                                        if (localDescription != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("Description cannot be null!!");
                                        }
                                    } if (localExtendAttributesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0",
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
        public static ADMaterialEntityType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ADMaterialEntityType object =
                new ADMaterialEntityType();

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
                    
                            if (!"ADMaterialEntityType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ADMaterialEntityType)com.dayang.adp.schema.adfileinfoentity._1_0.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MaterialID").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaterialID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MaterialName").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaterialName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MaterialType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMaterialType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MediumType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMediumType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","Standard").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setStandard(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","TotalLength").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTotalLength(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MarkIn").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMarkIn(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMarkIn(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","MarkOut").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMarkOut(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMarkOut(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","HDFlag").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHDFlag(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setHDFlag(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","AFD").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAFD(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","BusinessType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBusinessType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setBusinessType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","SubBusinessType").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSubBusinessType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setSubBusinessType(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","PrePlayColumn").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPrePlayColumn(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","PrePlayChannel").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPrePlayChannel(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","Description").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADMaterialEntity/1.0","ExtendAttributes").equals(reader.getName())){
                                
                                                object.setExtendAttributes(com.dayang.adp.schema.admaterialentity._1_0.ExtendAttributesTypeE.Factory.parse(reader));
                                              
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
           
          