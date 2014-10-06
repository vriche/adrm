
/**
 * StartCombineProcessRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:19:26 CET)
 */
            
                package com.dayang.adp.schema.adpserviceparametertype._0_1;
            

            /**
            *  StartCombineProcessRequestType bean class
            */
        
        public  class StartCombineProcessRequestType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = StartCombineProcessRequestType
                Namespace URI = http://dayang.com/ADP/schema/ADPServiceParameterType/0.1
                Namespace Prefix = ns7
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1")){
                return "ns7";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for CommonRequest
                        */

                        
                                    protected com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType localCommonRequest ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType
                           */
                           public  com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType getCommonRequest(){
                               return localCommonRequest;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CommonRequest
                               */
                               public void setCommonRequest(com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType param){
                            
                                            this.localCommonRequest=param;
                                    

                               }
                            

                        /**
                        * field for IsNeedQC
                        */

                        
                                    protected int localIsNeedQC ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getIsNeedQC(){
                               return localIsNeedQC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsNeedQC
                               */
                               public void setIsNeedQC(int param){
                            
                                            this.localIsNeedQC=param;
                                    

                               }
                            

                        /**
                        * field for CombineSourceFileGroup
                        */

                        
                                    protected com.dayang.adp.schema.adpserviceparametertype._0_1.CombineSourceFileType localCombineSourceFileGroup ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adpserviceparametertype._0_1.CombineSourceFileType
                           */
                           public  com.dayang.adp.schema.adpserviceparametertype._0_1.CombineSourceFileType getCombineSourceFileGroup(){
                               return localCombineSourceFileGroup;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CombineSourceFileGroup
                               */
                               public void setCombineSourceFileGroup(com.dayang.adp.schema.adpserviceparametertype._0_1.CombineSourceFileType param){
                            
                                            this.localCombineSourceFileGroup=param;
                                    

                               }
                            

                        /**
                        * field for CombineTargetFile
                        */

                        
                                    protected com.dayang.adp.schema.adpserviceparametertype._0_1.CombineTargetFileType localCombineTargetFile ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adpserviceparametertype._0_1.CombineTargetFileType
                           */
                           public  com.dayang.adp.schema.adpserviceparametertype._0_1.CombineTargetFileType getCombineTargetFile(){
                               return localCombineTargetFile;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CombineTargetFile
                               */
                               public void setCombineTargetFile(com.dayang.adp.schema.adpserviceparametertype._0_1.CombineTargetFileType param){
                            
                                            this.localCombineTargetFile=param;
                                    

                               }
                            

                        /**
                        * field for IsNeedTransLowCode
                        */

                        
                                    protected int localIsNeedTransLowCode ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getIsNeedTransLowCode(){
                               return localIsNeedTransLowCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsNeedTransLowCode
                               */
                               public void setIsNeedTransLowCode(int param){
                            
                                            this.localIsNeedTransLowCode=param;
                                    

                               }
                            

                        /**
                        * field for IsNeedKeyFrame
                        */

                        
                                    protected int localIsNeedKeyFrame ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getIsNeedKeyFrame(){
                               return localIsNeedKeyFrame;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsNeedKeyFrame
                               */
                               public void setIsNeedKeyFrame(int param){
                            
                                            this.localIsNeedKeyFrame=param;
                                    

                               }
                            

                        /**
                        * field for KeyFramePosition
                        */

                        
                                    protected com.dayang.adp.schema.adpserviceparametertype._0_1.KeyFramePositionType localKeyFramePosition ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localKeyFramePositionTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adpserviceparametertype._0_1.KeyFramePositionType
                           */
                           public  com.dayang.adp.schema.adpserviceparametertype._0_1.KeyFramePositionType getKeyFramePosition(){
                               return localKeyFramePosition;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param KeyFramePosition
                               */
                               public void setKeyFramePosition(com.dayang.adp.schema.adpserviceparametertype._0_1.KeyFramePositionType param){
                            
                                       if (param != null){
                                          //update the setting tracker
                                          localKeyFramePositionTracker = true;
                                       } else {
                                          localKeyFramePositionTracker = false;
                                              
                                       }
                                   
                                            this.localKeyFramePosition=param;
                                    

                               }
                            

                        /**
                        * field for IsNeedTechReport
                        */

                        
                                    protected int localIsNeedTechReport ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIsNeedTechReportTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getIsNeedTechReport(){
                               return localIsNeedTechReport;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IsNeedTechReport
                               */
                               public void setIsNeedTechReport(int param){
                            
                                       // setting primitive attribute tracker to true
                                       
                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localIsNeedTechReportTracker = false;
                                              
                                       } else {
                                          localIsNeedTechReportTracker = true;
                                       }
                                   
                                            this.localIsNeedTechReport=param;
                                    

                               }
                            

                        /**
                        * field for ExtendAttributes
                        */

                        
                                    protected com.dayang.adp.schema.adpserviceparametertype._0_1.ExtendAttributesType14 localExtendAttributes ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localExtendAttributesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.dayang.adp.schema.adpserviceparametertype._0_1.ExtendAttributesType14
                           */
                           public  com.dayang.adp.schema.adpserviceparametertype._0_1.ExtendAttributesType14 getExtendAttributes(){
                               return localExtendAttributes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ExtendAttributes
                               */
                               public void setExtendAttributes(com.dayang.adp.schema.adpserviceparametertype._0_1.ExtendAttributesType14 param){
                            
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
                       StartCombineProcessRequestType.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dayang.com/ADP/schema/ADPServiceParameterType/0.1");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":StartCombineProcessRequestType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "StartCombineProcessRequestType",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localCommonRequest==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CommonRequest cannot be null!!");
                                            }
                                           localCommonRequest.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CommonRequest"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://dayang.com/ADP/schema/ADPServiceParameterType/0.1";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsNeedQC", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsNeedQC");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsNeedQC");
                                    }
                                
                                               if (localIsNeedQC==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsNeedQC cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedQC));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localCombineSourceFileGroup==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CombineSourceFileGroup cannot be null!!");
                                            }
                                           localCombineSourceFileGroup.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CombineSourceFileGroup"),
                                               factory,xmlWriter);
                                        
                                            if (localCombineTargetFile==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CombineTargetFile cannot be null!!");
                                            }
                                           localCombineTargetFile.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CombineTargetFile"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://dayang.com/ADP/schema/ADPServiceParameterType/0.1";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsNeedTransLowCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsNeedTransLowCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsNeedTransLowCode");
                                    }
                                
                                               if (localIsNeedTransLowCode==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsNeedTransLowCode cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedTransLowCode));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://dayang.com/ADP/schema/ADPServiceParameterType/0.1";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsNeedKeyFrame", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsNeedKeyFrame");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsNeedKeyFrame");
                                    }
                                
                                               if (localIsNeedKeyFrame==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsNeedKeyFrame cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedKeyFrame));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                              if (localKeyFramePositionTracker){
                                            if (localKeyFramePosition==null){
                                                 throw new org.apache.axis2.databinding.ADBException("KeyFramePosition cannot be null!!");
                                            }
                                           localKeyFramePosition.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","KeyFramePosition"),
                                               factory,xmlWriter);
                                        } if (localIsNeedTechReportTracker){
                                    namespace = "http://dayang.com/ADP/schema/ADPServiceParameterType/0.1";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"IsNeedTechReport", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"IsNeedTechReport");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("IsNeedTechReport");
                                    }
                                
                                               if (localIsNeedTechReport==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("IsNeedTechReport cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedTechReport));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localExtendAttributesTracker){
                                            if (localExtendAttributes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ExtendAttributes cannot be null!!");
                                            }
                                           localExtendAttributes.serialize(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","ExtendAttributes"),
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

                
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "CommonRequest"));
                            
                            
                                    if (localCommonRequest==null){
                                         throw new org.apache.axis2.databinding.ADBException("CommonRequest cannot be null!!");
                                    }
                                    elementList.add(localCommonRequest);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "IsNeedQC"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedQC));
                            
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "CombineSourceFileGroup"));
                            
                            
                                    if (localCombineSourceFileGroup==null){
                                         throw new org.apache.axis2.databinding.ADBException("CombineSourceFileGroup cannot be null!!");
                                    }
                                    elementList.add(localCombineSourceFileGroup);
                                
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "CombineTargetFile"));
                            
                            
                                    if (localCombineTargetFile==null){
                                         throw new org.apache.axis2.databinding.ADBException("CombineTargetFile cannot be null!!");
                                    }
                                    elementList.add(localCombineTargetFile);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "IsNeedTransLowCode"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedTransLowCode));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "IsNeedKeyFrame"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedKeyFrame));
                             if (localKeyFramePositionTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "KeyFramePosition"));
                            
                            
                                    if (localKeyFramePosition==null){
                                         throw new org.apache.axis2.databinding.ADBException("KeyFramePosition cannot be null!!");
                                    }
                                    elementList.add(localKeyFramePosition);
                                } if (localIsNeedTechReportTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
                                                                      "IsNeedTechReport"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIsNeedTechReport));
                            } if (localExtendAttributesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1",
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
        public static StartCombineProcessRequestType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            StartCombineProcessRequestType object =
                new StartCombineProcessRequestType();

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
                    
                            if (!"StartCombineProcessRequestType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (StartCombineProcessRequestType)com.dayang.adp.schema.adfileinfoentity._1_0.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CommonRequest").equals(reader.getName())){
                                
                                                object.setCommonRequest(com.dayang.adp.schema.adpserviceparametertype._0_1.CommonRequestType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","IsNeedQC").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsNeedQC(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CombineSourceFileGroup").equals(reader.getName())){
                                
                                                object.setCombineSourceFileGroup(com.dayang.adp.schema.adpserviceparametertype._0_1.CombineSourceFileType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","CombineTargetFile").equals(reader.getName())){
                                
                                                object.setCombineTargetFile(com.dayang.adp.schema.adpserviceparametertype._0_1.CombineTargetFileType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","IsNeedTransLowCode").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsNeedTransLowCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","IsNeedKeyFrame").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsNeedKeyFrame(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","KeyFramePosition").equals(reader.getName())){
                                
                                                object.setKeyFramePosition(com.dayang.adp.schema.adpserviceparametertype._0_1.KeyFramePositionType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","IsNeedTechReport").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIsNeedTechReport(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setIsNeedTechReport(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dayang.com/ADP/schema/ADPServiceParameterType/0.1","ExtendAttributes").equals(reader.getName())){
                                
                                                object.setExtendAttributes(com.dayang.adp.schema.adpserviceparametertype._0_1.ExtendAttributesType14.Factory.parse(reader));
                                              
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
           
          