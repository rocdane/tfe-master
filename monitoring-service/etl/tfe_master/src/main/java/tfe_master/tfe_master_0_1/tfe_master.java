// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package tfe_master.tfe_master_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: tfe_master Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class tfe_master implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "tfe_master";
	private final String projectName = "TFE_MASTER";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				tfe_master.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(tfe_master.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_join_automobile_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_join_client_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_join_factor_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_join_spare_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_join_task_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBInput_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class load_dossierStruct implements routines.system.IPersistableRow<load_dossierStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long dossier_pk;

				public Long getDossier_pk () {
					return this.dossier_pk;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public java.util.Date period;

				public java.util.Date getPeriod () {
					return this.period;
				}
				
			    public String number;

				public String getNumber () {
					return this.number;
				}
				
			    public String vin;

				public String getVin () {
					return this.vin;
				}
				
			    public String make;

				public String getMake () {
					return this.make;
				}
				
			    public String model;

				public String getModel () {
					return this.model;
				}
				
			    public Integer trim;

				public Integer getTrim () {
					return this.trim;
				}
				
			    public String unit;

				public String getUnit () {
					return this.unit;
				}
				
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String legal_notice;

				public String getLegal_notice () {
					return this.legal_notice;
				}
				
			    public String contact;

				public String getContact () {
					return this.contact;
				}
				
			    public String address;

				public String getAddress () {
					return this.address;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.dossier_pk == null) ? 0 : this.dossier_pk.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final load_dossierStruct other = (load_dossierStruct) obj;
		
						if (this.dossier_pk == null) {
							if (other.dossier_pk != null)
								return false;
						
						} else if (!this.dossier_pk.equals(other.dossier_pk))
						
							return false;
					

		return true;
    }

	public void copyDataTo(load_dossierStruct other) {

		other.dossier_pk = this.dossier_pk;
	            other.reference = this.reference;
	            other.period = this.period;
	            other.number = this.number;
	            other.vin = this.vin;
	            other.make = this.make;
	            other.model = this.model;
	            other.trim = this.trim;
	            other.unit = this.unit;
	            other.name = this.name;
	            other.type = this.type;
	            other.legal_notice = this.legal_notice;
	            other.contact = this.contact;
	            other.address = this.address;
	            
	}

	public void copyKeysDataTo(load_dossierStruct other) {

		other.dossier_pk = this.dossier_pk;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.dossier_pk = null;
           				} else {
           			    	this.dossier_pk = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.period = readDate(dis);
					
					this.number = readString(dis);
					
					this.vin = readString(dis);
					
					this.make = readString(dis);
					
					this.model = readString(dis);
					
						this.trim = readInteger(dis);
					
					this.unit = readString(dis);
					
					this.name = readString(dis);
					
					this.type = readString(dis);
					
					this.legal_notice = readString(dis);
					
					this.contact = readString(dis);
					
					this.address = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.dossier_pk = null;
           				} else {
           			    	this.dossier_pk = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.period = readDate(dis);
					
					this.number = readString(dis);
					
					this.vin = readString(dis);
					
					this.make = readString(dis);
					
					this.model = readString(dis);
					
						this.trim = readInteger(dis);
					
					this.unit = readString(dis);
					
					this.name = readString(dis);
					
					this.type = readString(dis);
					
					this.legal_notice = readString(dis);
					
					this.contact = readString(dis);
					
					this.address = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.dossier_pk == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.dossier_pk);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.number,dos);
					
					// String
				
						writeString(this.vin,dos);
					
					// String
				
						writeString(this.make,dos);
					
					// String
				
						writeString(this.model,dos);
					
					// Integer
				
						writeInteger(this.trim,dos);
					
					// String
				
						writeString(this.unit,dos);
					
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.legal_notice,dos);
					
					// String
				
						writeString(this.contact,dos);
					
					// String
				
						writeString(this.address,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.dossier_pk == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.dossier_pk);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.number,dos);
					
					// String
				
						writeString(this.vin,dos);
					
					// String
				
						writeString(this.make,dos);
					
					// String
				
						writeString(this.model,dos);
					
					// Integer
				
						writeInteger(this.trim,dos);
					
					// String
				
						writeString(this.unit,dos);
					
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.type,dos);
					
					// String
				
						writeString(this.legal_notice,dos);
					
					// String
				
						writeString(this.contact,dos);
					
					// String
				
						writeString(this.address,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("dossier_pk="+String.valueOf(dossier_pk));
		sb.append(",reference="+reference);
		sb.append(",period="+String.valueOf(period));
		sb.append(",number="+number);
		sb.append(",vin="+vin);
		sb.append(",make="+make);
		sb.append(",model="+model);
		sb.append(",trim="+String.valueOf(trim));
		sb.append(",unit="+unit);
		sb.append(",name="+name);
		sb.append(",type="+type);
		sb.append(",legal_notice="+legal_notice);
		sb.append(",contact="+contact);
		sb.append(",address="+address);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(load_dossierStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.dossier_pk, other.dossier_pk);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class extract_dossierStruct implements routines.system.IPersistableRow<extract_dossierStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public java.util.Date open_at;

				public java.util.Date getOpen_at () {
					return this.open_at;
				}
				
			    public Long client;

				public Long getClient () {
					return this.client;
				}
				
			    public Long automobile;

				public Long getAutomobile () {
					return this.automobile;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.open_at = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.client = null;
           				} else {
           			    	this.client = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.automobile = null;
           				} else {
           			    	this.automobile = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.open_at = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.client = null;
           				} else {
           			    	this.client = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.automobile = null;
           				} else {
           			    	this.automobile = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.open_at,dos);
					
					// Long
				
						if(this.client == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.client);
		            	}
					
					// Long
				
						if(this.automobile == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.automobile);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.open_at,dos);
					
					// Long
				
						if(this.client == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.client);
		            	}
					
					// Long
				
						if(this.automobile == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.automobile);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",reference="+reference);
		sb.append(",open_at="+String.valueOf(open_at));
		sb.append(",client="+String.valueOf(client));
		sb.append(",automobile="+String.valueOf(automobile));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(extract_dossierStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public java.util.Date open_at;

				public java.util.Date getOpen_at () {
					return this.open_at;
				}
				
			    public Long client;

				public Long getClient () {
					return this.client;
				}
				
			    public Long automobile;

				public Long getAutomobile () {
					return this.automobile;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.id == null) {
							if (other.id != null)
								return false;
						
						} else if (!this.id.equals(other.id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.id = this.id;
	            other.reference = this.reference;
	            other.open_at = this.open_at;
	            other.client = this.client;
	            other.automobile = this.automobile;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.id = this.id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.open_at = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.client = null;
           				} else {
           			    	this.client = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.automobile = null;
           				} else {
           			    	this.automobile = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
					this.open_at = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.client = null;
           				} else {
           			    	this.client = dis.readLong();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.automobile = null;
           				} else {
           			    	this.automobile = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.open_at,dos);
					
					// Long
				
						if(this.client == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.client);
		            	}
					
					// Long
				
						if(this.automobile == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.automobile);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// java.util.Date
				
						writeDate(this.open_at,dos);
					
					// Long
				
						if(this.client == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.client);
		            	}
					
					// Long
				
						if(this.automobile == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.automobile);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",reference="+reference);
		sb.append(",open_at="+String.valueOf(open_at));
		sb.append(",client="+String.valueOf(client));
		sb.append(",automobile="+String.valueOf(automobile));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id, other.id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_2Process(globalMap);
		tDBInput_3Process(globalMap);

		extract_dossierStruct extract_dossier = new extract_dossierStruct();
load_dossierStruct load_dossier = new load_dossierStruct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"load_dossier");
					}
				
		int tos_count_tDBOutput_1 = 0;
		





String dbschema_tDBOutput_1 = null;
	dbschema_tDBOutput_1 = "";
	

String tableName_tDBOutput_1 = null;
if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
	tableName_tDBOutput_1 = ("fact_dossiers");
} else {
	tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("fact_dossiers");
}

        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 14 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

boolean whetherReject_tDBOutput_1 = false;

java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_1 = "jdbc:postgresql://"+"172.19.0.3"+":"+"5432"+"/"+"loga";
    dbUser_tDBOutput_1 = "loga";
 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:gYkz4IS2S2++cu9fRns9zNluOc8PDY6jN14xxWEyHWpT8uKw");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;



int count_tDBOutput_1=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_1 = "public";
                                    if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_1.next()){
                                                defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_1.next()) {
                                        String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
                                        String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_1.equals(("fact_dossiers"))
                                            && (schema_tDBOutput_1.equals(dbschema_tDBOutput_1) || ((dbschema_tDBOutput_1 ==null || dbschema_tDBOutput_1.trim().length() ==0) && defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
                                            whetherExist_tDBOutput_1 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1 + "\"(\"dossier_pk\" INT8 ,\"reference\" VARCHAR ,\"period\" TIMESTAMP ,\"number\" VARCHAR ,\"vin\" VARCHAR ,\"make\" VARCHAR ,\"model\" VARCHAR ,\"trim\" INT4 ,\"unit\" VARCHAR ,\"name\" VARCHAR ,\"type\" VARCHAR ,\"legal_notice\" VARCHAR ,\"contact\" VARCHAR ,\"address\" VARCHAR ,primary key(\"dossier_pk\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_1 + "\" WHERE \"dossier_pk\" = ?");
	    resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
	    String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1 + "\" (\"dossier_pk\",\"reference\",\"period\",\"number\",\"vin\",\"make\",\"model\",\"trim\",\"unit\",\"name\",\"type\",\"legal_notice\",\"contact\",\"address\") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
	    resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
	    String update_tDBOutput_1 = "UPDATE \"" + tableName_tDBOutput_1 + "\" SET \"reference\" = ?,\"period\" = ?,\"number\" = ?,\"vin\" = ?,\"make\" = ?,\"model\" = ?,\"trim\" = ?,\"unit\" = ?,\"name\" = ?,\"type\" = ?,\"legal_notice\" = ?,\"contact\" = ?,\"address\" = ? WHERE \"dossier_pk\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
	    resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);
	    

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"extract_dossier");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_automobileStruct> tHash_Lookup_join_automobile = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_automobileStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_automobileStruct>) 
					globalMap.get( "tHash_Lookup_join_automobile" ))
					;					
					
	

join_automobileStruct join_automobileHashKey = new join_automobileStruct();
join_automobileStruct join_automobileDefault = new join_automobileStruct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_clientStruct> tHash_Lookup_join_client = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_clientStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_clientStruct>) 
					globalMap.get( "tHash_Lookup_join_client" ))
					;					
					
	

join_clientStruct join_clientHashKey = new join_clientStruct();
join_clientStruct join_clientDefault = new join_clientStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
load_dossierStruct load_dossier_tmp = new load_dossierStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "loga";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:fFJC94msggeI4EdmCdx6mf089f8l4vPP697yVZEESa6Pr4+R");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
				String url_tDBInput_1 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
				conn_tDBInput_1.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "select id,reference,open_at,client,automobile from dossier";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								extract_dossier.id = null;
							} else {
		                          
            extract_dossier.id = rs_tDBInput_1.getLong(1);
            if(rs_tDBInput_1.wasNull()){
                    extract_dossier.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								extract_dossier.reference = null;
							} else {
	                         		
        	extract_dossier.reference = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								extract_dossier.open_at = null;
							} else {
										
			extract_dossier.open_at = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 3);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								extract_dossier.client = null;
							} else {
		                          
            extract_dossier.client = rs_tDBInput_1.getLong(4);
            if(rs_tDBInput_1.wasNull()){
                    extract_dossier.client = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								extract_dossier.automobile = null;
							} else {
		                          
            extract_dossier.automobile = rs_tDBInput_1.getLong(5);
            if(rs_tDBInput_1.wasNull()){
                    extract_dossier.automobile = null;
            }
		                    }
					


 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"extract_dossier"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "join_automobile" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopjoin_automobile = false;
       		  	    	
       		  	    	
 							join_automobileStruct join_automobileObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    join_automobileHashKey.id = extract_dossier.automobile;
                        		    		

								
		                        	join_automobileHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_join_automobile.lookup( join_automobileHashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_join_automobile != null && tHash_Lookup_join_automobile.getCount(join_automobileHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'join_automobile' and it contains more one result from keys :  join_automobile.id = '" + join_automobileHashKey.id + "'");
								} // G 071
							

							join_automobileStruct join_automobile = null;
                    		  	 
							   
                    		  	 
	       		  	    	join_automobileStruct fromLookup_join_automobile = null;
							join_automobile = join_automobileDefault;
										 
							
								 
							
							
								if (tHash_Lookup_join_automobile !=null && tHash_Lookup_join_automobile.hasNext()) { // G 099
								
							
								
								fromLookup_join_automobile = tHash_Lookup_join_automobile.next();

							
							
								} // G 099
							
							

							if(fromLookup_join_automobile != null) {
								join_automobile = fromLookup_join_automobile;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "join_client" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopjoin_client = false;
       		  	    	
       		  	    	
 							join_clientStruct join_clientObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    join_clientHashKey.id = extract_dossier.client;
                        		    		

								
		                        	join_clientHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_join_client.lookup( join_clientHashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_join_client != null && tHash_Lookup_join_client.getCount(join_clientHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'join_client' and it contains more one result from keys :  join_client.id = '" + join_clientHashKey.id + "'");
								} // G 071
							

							join_clientStruct join_client = null;
                    		  	 
							   
                    		  	 
	       		  	    	join_clientStruct fromLookup_join_client = null;
							join_client = join_clientDefault;
										 
							
								 
							
							
								if (tHash_Lookup_join_client !=null && tHash_Lookup_join_client.hasNext()) { // G 099
								
							
								
								fromLookup_join_client = tHash_Lookup_join_client.next();

							
							
								} // G 099
							
							

							if(fromLookup_join_client != null) {
								join_client = fromLookup_join_client;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

load_dossier = null;


// # Output table : 'load_dossier'
load_dossier_tmp.dossier_pk = extract_dossier.id ;
load_dossier_tmp.reference = extract_dossier.reference ;
load_dossier_tmp.period = extract_dossier.open_at ;
load_dossier_tmp.number = join_automobile.number ;
load_dossier_tmp.vin = join_automobile.vin ;
load_dossier_tmp.make = join_automobile.make ;
load_dossier_tmp.model = join_automobile.model ;
load_dossier_tmp.trim = join_automobile.trim ;
load_dossier_tmp.unit = join_automobile.unit ;
load_dossier_tmp.name = join_client.name ;
load_dossier_tmp.type = join_client.type ;
load_dossier_tmp.legal_notice = join_client.legal_notice ;
load_dossier_tmp.contact = join_client.contact ;
load_dossier_tmp.address = join_client.address ;
load_dossier = load_dossier_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "load_dossier"
if(load_dossier != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"load_dossier"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                    if(load_dossier.dossier_pk == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setLong(1, load_dossier.dossier_pk);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(load_dossier.reference == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, load_dossier.reference);
}

                        if(load_dossier.period != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(2, new java.sql.Timestamp(load_dossier.period.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(load_dossier.number == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, load_dossier.number);
}

                        if(load_dossier.vin == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, load_dossier.vin);
}

                        if(load_dossier.make == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, load_dossier.make);
}

                        if(load_dossier.model == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(6, load_dossier.model);
}

                        if(load_dossier.trim == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(7, load_dossier.trim);
}

                        if(load_dossier.unit == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(8, load_dossier.unit);
}

                        if(load_dossier.name == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(9, load_dossier.name);
}

                        if(load_dossier.type == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(10, load_dossier.type);
}

                        if(load_dossier.legal_notice == null) {
pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(11, load_dossier.legal_notice);
}

                        if(load_dossier.contact == null) {
pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(12, load_dossier.contact);
}

                        if(load_dossier.address == null) {
pstmtUpdate_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(13, load_dossier.address);
}

                        if(load_dossier.dossier_pk == null) {
pstmtUpdate_tDBOutput_1.setNull(14 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setLong(14 + count_tDBOutput_1, load_dossier.dossier_pk);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            } else {
                        if(load_dossier.dossier_pk == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setLong(1, load_dossier.dossier_pk);
}

                        if(load_dossier.reference == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, load_dossier.reference);
}

                        if(load_dossier.period != null) {
pstmtInsert_tDBOutput_1.setTimestamp(3, new java.sql.Timestamp(load_dossier.period.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.TIMESTAMP);
}

                        if(load_dossier.number == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, load_dossier.number);
}

                        if(load_dossier.vin == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, load_dossier.vin);
}

                        if(load_dossier.make == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, load_dossier.make);
}

                        if(load_dossier.model == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(7, load_dossier.model);
}

                        if(load_dossier.trim == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(8, load_dossier.trim);
}

                        if(load_dossier.unit == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(9, load_dossier.unit);
}

                        if(load_dossier.name == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(10, load_dossier.name);
}

                        if(load_dossier.type == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(11, load_dossier.type);
}

                        if(load_dossier.legal_notice == null) {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(12, load_dossier.legal_notice);
}

                        if(load_dossier.contact == null) {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(13, load_dossier.contact);
}

                        if(load_dossier.address == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(14, load_dossier.address);
}

                try {
					
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_1 = true;
                        nb_line_tDBOutput_1++;
                            System.err.print(e.getMessage());
                }
            }
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "load_dossier"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
	if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
		
			conn_tDBInput_1.commit();
			
		
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_join_automobile != null) {
						tHash_Lookup_join_automobile.endGet();
					}
					globalMap.remove( "tHash_Lookup_join_automobile" );

					
					
				
					if(tHash_Lookup_join_client != null) {
						tHash_Lookup_join_client.endGet();
					}
					globalMap.remove( "tHash_Lookup_join_client" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"extract_dossier");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
        if(pstmt_tDBOutput_1 != null) {
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
			}
			conn_tDBOutput_1.commit();
			if(rowsToCommitCount_tDBOutput_1 != 0){
				
				rowsToCommitCount_tDBOutput_1 = 0;
			}
			commitCounter_tDBOutput_1 = 0;
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"load_dossier");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_join_automobile"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_join_client"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class join_automobileStruct implements routines.system.IPersistableComparableLookupRow<join_automobileStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String number;

				public String getNumber () {
					return this.number;
				}
				
			    public String vin;

				public String getVin () {
					return this.vin;
				}
				
			    public String make;

				public String getMake () {
					return this.make;
				}
				
			    public String model;

				public String getModel () {
					return this.model;
				}
				
			    public Integer trim;

				public Integer getTrim () {
					return this.trim;
				}
				
			    public String unit;

				public String getUnit () {
					return this.unit;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final join_automobileStruct other = (join_automobileStruct) obj;
		
						if (this.id == null) {
							if (other.id != null)
								return false;
						
						} else if (!this.id.equals(other.id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(join_automobileStruct other) {

		other.id = this.id;
	            other.number = this.number;
	            other.vin = this.vin;
	            other.make = this.make;
	            other.model = this.model;
	            other.trim = this.trim;
	            other.unit = this.unit;
	            
	}

	public void copyKeysDataTo(join_automobileStruct other) {

		other.id = this.id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.number = readString(dis,ois);
					
						this.vin = readString(dis,ois);
					
						this.make = readString(dis,ois);
					
						this.model = readString(dis,ois);
					
						this.trim = readInteger(dis,ois);
					
						this.unit = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.number = readString(dis,objectIn);
					
						this.vin = readString(dis,objectIn);
					
						this.make = readString(dis,objectIn);
					
						this.model = readString(dis,objectIn);
					
						this.trim = readInteger(dis,objectIn);
					
						this.unit = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.number, dos, oos);
					
						writeString(this.vin, dos, oos);
					
						writeString(this.make, dos, oos);
					
						writeString(this.model, dos, oos);
					
					writeInteger(this.trim, dos, oos);
					
						writeString(this.unit, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.number, dos, objectOut);
					
						writeString(this.vin, dos, objectOut);
					
						writeString(this.make, dos, objectOut);
					
						writeString(this.model, dos, objectOut);
					
					writeInteger(this.trim, dos, objectOut);
					
						writeString(this.unit, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",number="+number);
		sb.append(",vin="+vin);
		sb.append(",make="+make);
		sb.append(",model="+model);
		sb.append(",trim="+String.valueOf(trim));
		sb.append(",unit="+unit);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(join_automobileStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id, other.id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		join_automobileStruct join_automobile = new join_automobileStruct();




	
	/**
	 * [tAdvancedHash_join_automobile begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_join_automobile", false);
		start_Hash.put("tAdvancedHash_join_automobile", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_join_automobile";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"join_automobile");
					}
				
		int tos_count_tAdvancedHash_join_automobile = 0;
		

			   		// connection name:join_automobile
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(join_automobile,join_automobile) | target node:tAdvancedHash_join_automobile - inputs:(join_automobile) outputs:()
			   		// linked node: tMap_1 - inputs:(extract_dossier,join_automobile,join_client) outputs:(load_dossier)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_join_automobile = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_automobileStruct> tHash_Lookup_join_automobile =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<join_automobileStruct>getLookup(matchingModeEnum_join_automobile);
	   						   
		   	   	   globalMap.put("tHash_Lookup_join_automobile", tHash_Lookup_join_automobile);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_join_automobile begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "loga";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/yr5yyEiSQ/rkDxNhNfUoevtPkGvXQ86p/i5JkmxJrMfIGiq");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
				String url_tDBInput_2 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
				conn_tDBInput_2.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "select id,number,vin,make,model,trim,unit from automobile";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								join_automobile.id = null;
							} else {
		                          
            join_automobile.id = rs_tDBInput_2.getLong(1);
            if(rs_tDBInput_2.wasNull()){
                    join_automobile.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								join_automobile.number = null;
							} else {
	                         		
        	join_automobile.number = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								join_automobile.vin = null;
							} else {
	                         		
        	join_automobile.vin = routines.system.JDBCUtil.getString(rs_tDBInput_2, 3, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								join_automobile.make = null;
							} else {
	                         		
        	join_automobile.make = routines.system.JDBCUtil.getString(rs_tDBInput_2, 4, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								join_automobile.model = null;
							} else {
	                         		
        	join_automobile.model = routines.system.JDBCUtil.getString(rs_tDBInput_2, 5, false);
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								join_automobile.trim = null;
							} else {
		                          
            join_automobile.trim = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    join_automobile.trim = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								join_automobile.unit = null;
							} else {
	                         		
        	join_automobile.unit = routines.system.JDBCUtil.getString(rs_tDBInput_2, 7, false);
		                    }
					


 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_join_automobile main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_automobile";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"join_automobile"
						
						);
					}
					


			   
			   

					join_automobileStruct join_automobile_HashRow = new join_automobileStruct();
		   	   	   
				
				join_automobile_HashRow.id = join_automobile.id;
				
				join_automobile_HashRow.number = join_automobile.number;
				
				join_automobile_HashRow.vin = join_automobile.vin;
				
				join_automobile_HashRow.make = join_automobile.make;
				
				join_automobile_HashRow.model = join_automobile.model;
				
				join_automobile_HashRow.trim = join_automobile.trim;
				
				join_automobile_HashRow.unit = join_automobile.unit;
				
			tHash_Lookup_join_automobile.put(join_automobile_HashRow);
			
            




 


	tos_count_tAdvancedHash_join_automobile++;

/**
 * [tAdvancedHash_join_automobile main ] stop
 */
	
	/**
	 * [tAdvancedHash_join_automobile process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_automobile";

	

 



/**
 * [tAdvancedHash_join_automobile process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_join_automobile process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_automobile";

	

 



/**
 * [tAdvancedHash_join_automobile process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
	if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
		
			conn_tDBInput_2.commit();
			
		
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);
 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_join_automobile end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_automobile";

	

tHash_Lookup_join_automobile.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"join_automobile");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_join_automobile", true);
end_Hash.put("tAdvancedHash_join_automobile", System.currentTimeMillis());




/**
 * [tAdvancedHash_join_automobile end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_join_automobile finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_automobile";

	

 



/**
 * [tAdvancedHash_join_automobile finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class join_clientStruct implements routines.system.IPersistableComparableLookupRow<join_clientStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String type;

				public String getType () {
					return this.type;
				}
				
			    public String legal_notice;

				public String getLegal_notice () {
					return this.legal_notice;
				}
				
			    public String contact;

				public String getContact () {
					return this.contact;
				}
				
			    public String address;

				public String getAddress () {
					return this.address;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final join_clientStruct other = (join_clientStruct) obj;
		
						if (this.id == null) {
							if (other.id != null)
								return false;
						
						} else if (!this.id.equals(other.id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(join_clientStruct other) {

		other.id = this.id;
	            other.name = this.name;
	            other.type = this.type;
	            other.legal_notice = this.legal_notice;
	            other.contact = this.contact;
	            other.address = this.address;
	            
	}

	public void copyKeysDataTo(join_clientStruct other) {

		other.id = this.id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.name = readString(dis,ois);
					
						this.type = readString(dis,ois);
					
						this.legal_notice = readString(dis,ois);
					
						this.contact = readString(dis,ois);
					
						this.address = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.name = readString(dis,objectIn);
					
						this.type = readString(dis,objectIn);
					
						this.legal_notice = readString(dis,objectIn);
					
						this.contact = readString(dis,objectIn);
					
						this.address = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.name, dos, oos);
					
						writeString(this.type, dos, oos);
					
						writeString(this.legal_notice, dos, oos);
					
						writeString(this.contact, dos, oos);
					
						writeString(this.address, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.name, dos, objectOut);
					
						writeString(this.type, dos, objectOut);
					
						writeString(this.legal_notice, dos, objectOut);
					
						writeString(this.contact, dos, objectOut);
					
						writeString(this.address, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",name="+name);
		sb.append(",type="+type);
		sb.append(",legal_notice="+legal_notice);
		sb.append(",contact="+contact);
		sb.append(",address="+address);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(join_clientStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.id, other.id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		join_clientStruct join_client = new join_clientStruct();




	
	/**
	 * [tAdvancedHash_join_client begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_join_client", false);
		start_Hash.put("tAdvancedHash_join_client", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_join_client";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"join_client");
					}
				
		int tos_count_tAdvancedHash_join_client = 0;
		

			   		// connection name:join_client
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(join_client,join_client) | target node:tAdvancedHash_join_client - inputs:(join_client) outputs:()
			   		// linked node: tMap_1 - inputs:(extract_dossier,join_automobile,join_client) outputs:(load_dossier)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_join_client = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_clientStruct> tHash_Lookup_join_client =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<join_clientStruct>getLookup(matchingModeEnum_join_client);
	   						   
		   	   	   globalMap.put("tHash_Lookup_join_client", tHash_Lookup_join_client);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_join_client begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "loga";
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:HQ8OzoX6sldozfkr2KxiPkDxlq5ICMqaaXaW419JWImFyBQE");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
				String url_tDBInput_3 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
				conn_tDBInput_3.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "select id,name,type,legal_notice,contact,address from client";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								join_client.id = null;
							} else {
		                          
            join_client.id = rs_tDBInput_3.getLong(1);
            if(rs_tDBInput_3.wasNull()){
                    join_client.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								join_client.name = null;
							} else {
	                         		
        	join_client.name = routines.system.JDBCUtil.getString(rs_tDBInput_3, 2, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								join_client.type = null;
							} else {
	                         		
        	join_client.type = routines.system.JDBCUtil.getString(rs_tDBInput_3, 3, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								join_client.legal_notice = null;
							} else {
	                         		
        	join_client.legal_notice = routines.system.JDBCUtil.getString(rs_tDBInput_3, 4, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								join_client.contact = null;
							} else {
	                         		
        	join_client.contact = routines.system.JDBCUtil.getString(rs_tDBInput_3, 5, false);
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								join_client.address = null;
							} else {
	                         		
        	join_client.address = routines.system.JDBCUtil.getString(rs_tDBInput_3, 6, false);
		                    }
					


 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_join_client main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_client";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"join_client"
						
						);
					}
					


			   
			   

					join_clientStruct join_client_HashRow = new join_clientStruct();
		   	   	   
				
				join_client_HashRow.id = join_client.id;
				
				join_client_HashRow.name = join_client.name;
				
				join_client_HashRow.type = join_client.type;
				
				join_client_HashRow.legal_notice = join_client.legal_notice;
				
				join_client_HashRow.contact = join_client.contact;
				
				join_client_HashRow.address = join_client.address;
				
			tHash_Lookup_join_client.put(join_client_HashRow);
			
            




 


	tos_count_tAdvancedHash_join_client++;

/**
 * [tAdvancedHash_join_client main ] stop
 */
	
	/**
	 * [tAdvancedHash_join_client process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_client";

	

 



/**
 * [tAdvancedHash_join_client process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_join_client process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_client";

	

 



/**
 * [tAdvancedHash_join_client process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
	if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
		
			conn_tDBInput_3.commit();
			
		
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);
 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_join_client end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_client";

	

tHash_Lookup_join_client.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"join_client");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_join_client", true);
end_Hash.put("tAdvancedHash_join_client", System.currentTimeMillis());




/**
 * [tAdvancedHash_join_client end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_join_client finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_client";

	

 



/**
 * [tAdvancedHash_join_client finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class load_diagnosisStruct implements routines.system.IPersistableRow<load_diagnosisStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Integer pk_diagnosis;

				public Integer getPk_diagnosis () {
					return this.pk_diagnosis;
				}
				
			    public Long diagnosis;

				public Long getDiagnosis () {
					return this.diagnosis;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public java.util.Date period;

				public java.util.Date getPeriod () {
					return this.period;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public String entity;

				public String getEntity () {
					return this.entity;
				}
				
			    public String dysfunction;

				public String getDysfunction () {
					return this.dysfunction;
				}
				
			    public String maintenance;

				public String getMaintenance () {
					return this.maintenance;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_diagnosis = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.diagnosis = null;
           				} else {
           			    	this.diagnosis = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.period = readDate(dis);
					
					this.dossier = readString(dis);
					
					this.entity = readString(dis);
					
					this.dysfunction = readString(dis);
					
					this.maintenance = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_diagnosis = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.diagnosis = null;
           				} else {
           			    	this.diagnosis = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.period = readDate(dis);
					
					this.dossier = readString(dis);
					
					this.entity = readString(dis);
					
					this.dysfunction = readString(dis);
					
					this.maintenance = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_diagnosis,dos);
					
					// Long
				
						if(this.diagnosis == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.diagnosis);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// String
				
						writeString(this.entity,dos);
					
					// String
				
						writeString(this.dysfunction,dos);
					
					// String
				
						writeString(this.maintenance,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_diagnosis,dos);
					
					// Long
				
						if(this.diagnosis == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.diagnosis);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// String
				
						writeString(this.entity,dos);
					
					// String
				
						writeString(this.dysfunction,dos);
					
					// String
				
						writeString(this.maintenance,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("pk_diagnosis="+String.valueOf(pk_diagnosis));
		sb.append(",diagnosis="+String.valueOf(diagnosis));
		sb.append(",reference="+reference);
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",description="+description);
		sb.append(",period="+String.valueOf(period));
		sb.append(",dossier="+dossier);
		sb.append(",entity="+entity);
		sb.append(",dysfunction="+dysfunction);
		sb.append(",maintenance="+maintenance);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(load_diagnosisStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class extract_diagnosisStruct implements routines.system.IPersistableRow<extract_diagnosisStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.created_at = readDate(dis);
					
					this.dossier = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.created_at = readDate(dis);
					
					this.dossier = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",reference="+reference);
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",description="+description);
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",dossier="+dossier);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(extract_diagnosisStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_4Struct implements routines.system.IPersistableRow<after_tDBInput_4Struct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.created_at = readDate(dis);
					
					this.dossier = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.reference = readString(dis);
					
						this.mileage = readInteger(dis);
					
					this.description = readString(dis);
					
					this.created_at = readDate(dis);
					
					this.dossier = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// String
				
						writeString(this.reference,dos);
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",reference="+reference);
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",description="+description);
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",dossier="+dossier);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_5Process(globalMap);

		extract_diagnosisStruct extract_diagnosis = new extract_diagnosisStruct();
load_diagnosisStruct load_diagnosis = new load_diagnosisStruct();





	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"load_diagnosis");
					}
				
		int tos_count_tDBOutput_2 = 0;
		





String dbschema_tDBOutput_2 = null;
	dbschema_tDBOutput_2 = "";
	

String tableName_tDBOutput_2 = null;
if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
	tableName_tDBOutput_2 = ("fact_diagnosis");
} else {
	tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("fact_diagnosis");
}

        int updateKeyCount_tDBOutput_2 = 1;
        if(updateKeyCount_tDBOutput_2 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_2 == 10 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

boolean whetherReject_tDBOutput_2 = false;

java.sql.Connection conn_tDBOutput_2 = null;
String dbUser_tDBOutput_2 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_2 = "jdbc:postgresql://"+"172.19.0.3"+":"+"5432"+"/"+"loga";
    dbUser_tDBOutput_2 = "loga";
 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:u3IU+gsnio3s1+uc3CVEMjSS1Cti2K60TqJcP3qqN0+m+PXp");

    String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;

    conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2,dbUser_tDBOutput_2,dbPwd_tDBOutput_2);
	
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;



int count_tDBOutput_2=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_2 = conn_tDBOutput_2.getMetaData();
                                boolean whetherExist_tDBOutput_2 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_2 = dbMetaData_tDBOutput_2.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_2 = "public";
                                    if(dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_2 = conn_tDBOutput_2.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_2 = stmtSchema_tDBOutput_2.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_2.next()){
                                                defaultSchema_tDBOutput_2 = rsSchema_tDBOutput_2.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_2.next()) {
                                        String table_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_NAME");
                                        String schema_tDBOutput_2 = rsTable_tDBOutput_2.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_2.equals(("fact_diagnosis"))
                                            && (schema_tDBOutput_2.equals(dbschema_tDBOutput_2) || ((dbschema_tDBOutput_2 ==null || dbschema_tDBOutput_2.trim().length() ==0) && defaultSchema_tDBOutput_2.equals(schema_tDBOutput_2)))) {
                                            whetherExist_tDBOutput_2 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_2) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_2 = conn_tDBOutput_2.createStatement()) {
                                        stmtCreate_tDBOutput_2.execute("CREATE TABLE \"" + tableName_tDBOutput_2 + "\"(\"pk_diagnosis\" INT4 ,\"diagnosis\" INT8 ,\"reference\" VARCHAR ,\"mileage\" INT4 ,\"description\" VARCHAR ,\"period\" TIMESTAMP ,\"dossier\" VARCHAR ,\"entity\" VARCHAR ,\"dysfunction\" VARCHAR ,\"maintenance\" VARCHAR ,primary key(\"pk_diagnosis\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_2 + "\" WHERE \"pk_diagnosis\" = ?");
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    String insert_tDBOutput_2 = "INSERT INTO \"" + tableName_tDBOutput_2 + "\" (\"pk_diagnosis\",\"diagnosis\",\"reference\",\"mileage\",\"description\",\"period\",\"dossier\",\"entity\",\"dysfunction\",\"maintenance\") VALUES (?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
	    resourceMap.put("pstmtInsert_tDBOutput_2", pstmtInsert_tDBOutput_2);
	    String update_tDBOutput_2 = "UPDATE \"" + tableName_tDBOutput_2 + "\" SET \"diagnosis\" = ?,\"reference\" = ?,\"mileage\" = ?,\"description\" = ?,\"period\" = ?,\"dossier\" = ?,\"entity\" = ?,\"dysfunction\" = ?,\"maintenance\" = ? WHERE \"pk_diagnosis\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
	    resourceMap.put("pstmtUpdate_tDBOutput_2", pstmtUpdate_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"extract_diagnosis");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_factorStruct> tHash_Lookup_join_factor = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_factorStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_factorStruct>) 
					globalMap.get( "tHash_Lookup_join_factor" ))
					;					
					
	

join_factorStruct join_factorHashKey = new join_factorStruct();
join_factorStruct join_factorDefault = new join_factorStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
load_diagnosisStruct load_diagnosis_tmp = new load_diagnosisStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "loga";
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Ae6QaTvPujSimousmcZIGjh2zVKnogMG6oqpgPBQ7qr2iasZ");
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
				String url_tDBInput_4 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
				conn_tDBInput_4.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "select id, reference, mileage, description, created_at, dossier from diagnosis";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								extract_diagnosis.id = null;
							} else {
		                          
            extract_diagnosis.id = rs_tDBInput_4.getLong(1);
            if(rs_tDBInput_4.wasNull()){
                    extract_diagnosis.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								extract_diagnosis.reference = null;
							} else {
	                         		
        	extract_diagnosis.reference = routines.system.JDBCUtil.getString(rs_tDBInput_4, 2, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								extract_diagnosis.mileage = null;
							} else {
		                          
            extract_diagnosis.mileage = rs_tDBInput_4.getInt(3);
            if(rs_tDBInput_4.wasNull()){
                    extract_diagnosis.mileage = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								extract_diagnosis.description = null;
							} else {
	                         		
        	extract_diagnosis.description = routines.system.JDBCUtil.getString(rs_tDBInput_4, 4, false);
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								extract_diagnosis.created_at = null;
							} else {
										
			extract_diagnosis.created_at = routines.system.JDBCUtil.getDate(rs_tDBInput_4, 5);
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								extract_diagnosis.dossier = null;
							} else {
	                         		
        	extract_diagnosis.dossier = routines.system.JDBCUtil.getString(rs_tDBInput_4, 6, false);
		                    }
					


 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"extract_diagnosis"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "join_factor" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopjoin_factor = false;
       		  	    	
       		  	    	
 							join_factorStruct join_factorObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    join_factorHashKey.diagnosis = extract_diagnosis.id;
                        		    		

								
		                        	join_factorHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_join_factor.lookup( join_factorHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_join_factor.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLoopjoin_factor = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopjoin_factor = true;
			           		  	} // G 21
                    		  	
                    		

							join_factorStruct join_factor = null;
                    		  	 
							

								while ((tHash_Lookup_join_factor != null && tHash_Lookup_join_factor.hasNext()) || forceLoopjoin_factor) { // G_TM_M_043

								
									 // CALL close loop of lookup 'join_factor'
									
                    		  	 
							   
                    		  	 
	       		  	    	join_factorStruct fromLookup_join_factor = null;
							join_factor = join_factorDefault;
										 
							
								
								if(!forceLoopjoin_factor) { // G 46
								
							
								 
							
								
								fromLookup_join_factor = tHash_Lookup_join_factor.next();

							

							if(fromLookup_join_factor != null) {
								join_factor = fromLookup_join_factor;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopjoin_factor = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

load_diagnosis = null;


// # Output table : 'load_diagnosis'
load_diagnosis_tmp.pk_diagnosis = Numeric.sequence("s1",1,1) ;
load_diagnosis_tmp.diagnosis = extract_diagnosis.id ;
load_diagnosis_tmp.reference = extract_diagnosis.reference ;
load_diagnosis_tmp.mileage = extract_diagnosis.mileage ;
load_diagnosis_tmp.description = extract_diagnosis.description ;
load_diagnosis_tmp.period = extract_diagnosis.created_at ;
load_diagnosis_tmp.dossier = extract_diagnosis.dossier ;
load_diagnosis_tmp.entity = join_factor.entity ;
load_diagnosis_tmp.dysfunction = join_factor.dysfunction ;
load_diagnosis_tmp.maintenance = join_factor.maintenance ;
load_diagnosis = load_diagnosis_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "load_diagnosis"
if(load_diagnosis != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"load_diagnosis"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(load_diagnosis.pk_diagnosis == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setInt(1, load_diagnosis.pk_diagnosis);
}

            int checkCount_tDBOutput_2 = -1;
            try (java.sql.ResultSet rs_tDBOutput_2 = pstmt_tDBOutput_2.executeQuery()) {
                while(rs_tDBOutput_2.next()) {
                    checkCount_tDBOutput_2 = rs_tDBOutput_2.getInt(1);
                }
            }
            if(checkCount_tDBOutput_2 > 0) {
                        if(load_diagnosis.diagnosis == null) {
pstmtUpdate_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_2.setLong(1, load_diagnosis.diagnosis);
}

                        if(load_diagnosis.reference == null) {
pstmtUpdate_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(2, load_diagnosis.reference);
}

                        if(load_diagnosis.mileage == null) {
pstmtUpdate_tDBOutput_2.setNull(3, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_2.setInt(3, load_diagnosis.mileage);
}

                        if(load_diagnosis.description == null) {
pstmtUpdate_tDBOutput_2.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(4, load_diagnosis.description);
}

                        if(load_diagnosis.period != null) {
pstmtUpdate_tDBOutput_2.setTimestamp(5, new java.sql.Timestamp(load_diagnosis.period.getTime()));
} else {
pstmtUpdate_tDBOutput_2.setNull(5, java.sql.Types.TIMESTAMP);
}

                        if(load_diagnosis.dossier == null) {
pstmtUpdate_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(6, load_diagnosis.dossier);
}

                        if(load_diagnosis.entity == null) {
pstmtUpdate_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(7, load_diagnosis.entity);
}

                        if(load_diagnosis.dysfunction == null) {
pstmtUpdate_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(8, load_diagnosis.dysfunction);
}

                        if(load_diagnosis.maintenance == null) {
pstmtUpdate_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_2.setString(9, load_diagnosis.maintenance);
}

                        if(load_diagnosis.pk_diagnosis == null) {
pstmtUpdate_tDBOutput_2.setNull(10 + count_tDBOutput_2, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_2.setInt(10 + count_tDBOutput_2, load_diagnosis.pk_diagnosis);
}

                try {
					
                    int processedCount_tDBOutput_2 = pstmtUpdate_tDBOutput_2.executeUpdate();
                    updatedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_2 = true;
                        nb_line_tDBOutput_2++;
                            System.err.print(e.getMessage());
                }
            } else {
                        if(load_diagnosis.pk_diagnosis == null) {
pstmtInsert_tDBOutput_2.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_2.setInt(1, load_diagnosis.pk_diagnosis);
}

                        if(load_diagnosis.diagnosis == null) {
pstmtInsert_tDBOutput_2.setNull(2, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_2.setLong(2, load_diagnosis.diagnosis);
}

                        if(load_diagnosis.reference == null) {
pstmtInsert_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(3, load_diagnosis.reference);
}

                        if(load_diagnosis.mileage == null) {
pstmtInsert_tDBOutput_2.setNull(4, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_2.setInt(4, load_diagnosis.mileage);
}

                        if(load_diagnosis.description == null) {
pstmtInsert_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(5, load_diagnosis.description);
}

                        if(load_diagnosis.period != null) {
pstmtInsert_tDBOutput_2.setTimestamp(6, new java.sql.Timestamp(load_diagnosis.period.getTime()));
} else {
pstmtInsert_tDBOutput_2.setNull(6, java.sql.Types.TIMESTAMP);
}

                        if(load_diagnosis.dossier == null) {
pstmtInsert_tDBOutput_2.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(7, load_diagnosis.dossier);
}

                        if(load_diagnosis.entity == null) {
pstmtInsert_tDBOutput_2.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(8, load_diagnosis.entity);
}

                        if(load_diagnosis.dysfunction == null) {
pstmtInsert_tDBOutput_2.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(9, load_diagnosis.dysfunction);
}

                        if(load_diagnosis.maintenance == null) {
pstmtInsert_tDBOutput_2.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_2.setString(10, load_diagnosis.maintenance);
}

                try {
					
                    int processedCount_tDBOutput_2 = pstmtInsert_tDBOutput_2.executeUpdate();
                    insertedCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
                    nb_line_tDBOutput_2++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_2 = true;
                        nb_line_tDBOutput_2++;
                            System.err.print(e.getMessage());
                }
            }
    		    commitCounter_tDBOutput_2++;
                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    	
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;
                }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "load_diagnosis"



	
		} // close loop of lookup 'join_factor' // G_TM_M_043
	
	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
	if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
		
			conn_tDBInput_4.commit();
			
		
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);
 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_join_factor != null) {
						tHash_Lookup_join_factor.endGet();
					}
					globalMap.remove( "tHash_Lookup_join_factor" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"extract_diagnosis");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



        if(pstmtUpdate_tDBOutput_2 != null){
            pstmtUpdate_tDBOutput_2.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_2");
        }
        if(pstmtInsert_tDBOutput_2 != null){
            pstmtInsert_tDBOutput_2.close();
            resourceMap.remove("pstmtInsert_tDBOutput_2");
        }
        if(pstmt_tDBOutput_2 != null) {
            pstmt_tDBOutput_2.close();
            resourceMap.remove("pstmt_tDBOutput_2");
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);
			if(rowsToCommitCount_tDBOutput_2 != 0){
				
			}
			conn_tDBOutput_2.commit();
			if(rowsToCommitCount_tDBOutput_2 != 0){
				
				rowsToCommitCount_tDBOutput_2 = 0;
			}
			commitCounter_tDBOutput_2 = 0;
		
    	conn_tDBOutput_2 .close();
    	
    	resourceMap.put("finish_tDBOutput_2", true);
    	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"load_diagnosis");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_join_factor"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_2 = null;
                if ((pstmtUpdateToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_2")) != null) {
                    pstmtUpdateToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_2 = null;
                if ((pstmtInsertToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_2")) != null) {
                    pstmtInsertToClose_tDBOutput_2.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                    ctn_tDBOutput_2.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class join_factorStruct implements routines.system.IPersistableComparableLookupRow<join_factorStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String entity;

				public String getEntity () {
					return this.entity;
				}
				
			    public String dysfunction;

				public String getDysfunction () {
					return this.dysfunction;
				}
				
			    public String maintenance;

				public String getMaintenance () {
					return this.maintenance;
				}
				
			    public Long diagnosis;

				public Long getDiagnosis () {
					return this.diagnosis;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.diagnosis == null) ? 0 : this.diagnosis.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final join_factorStruct other = (join_factorStruct) obj;
		
						if (this.diagnosis == null) {
							if (other.diagnosis != null)
								return false;
						
						} else if (!this.diagnosis.equals(other.diagnosis))
						
							return false;
					

		return true;
    }

	public void copyDataTo(join_factorStruct other) {

		other.id = this.id;
	            other.entity = this.entity;
	            other.dysfunction = this.dysfunction;
	            other.maintenance = this.maintenance;
	            other.diagnosis = this.diagnosis;
	            
	}

	public void copyKeysDataTo(join_factorStruct other) {

		other.diagnosis = this.diagnosis;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.diagnosis = null;
           				} else {
           			    	this.diagnosis = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.diagnosis = null;
           				} else {
           			    	this.diagnosis = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.diagnosis == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.diagnosis);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.diagnosis == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.diagnosis);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
						this.entity = readString(dis,ois);
					
						this.dysfunction = readString(dis,ois);
					
						this.maintenance = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = objectIn.readLong();
           				}
					
						this.entity = readString(dis,objectIn);
					
						this.dysfunction = readString(dis,objectIn);
					
						this.maintenance = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
						writeString(this.entity, dos, oos);
					
						writeString(this.dysfunction, dos, oos);
					
						writeString(this.maintenance, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.id);
		            	}
					
						writeString(this.entity, dos, objectOut);
					
						writeString(this.dysfunction, dos, objectOut);
					
						writeString(this.maintenance, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",entity="+entity);
		sb.append(",dysfunction="+dysfunction);
		sb.append(",maintenance="+maintenance);
		sb.append(",diagnosis="+String.valueOf(diagnosis));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(join_factorStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.diagnosis, other.diagnosis);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		join_factorStruct join_factor = new join_factorStruct();




	
	/**
	 * [tAdvancedHash_join_factor begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_join_factor", false);
		start_Hash.put("tAdvancedHash_join_factor", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_join_factor";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"join_factor");
					}
				
		int tos_count_tAdvancedHash_join_factor = 0;
		

			   		// connection name:join_factor
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_4) outputs:(join_factor,join_factor) | target node:tAdvancedHash_join_factor - inputs:(join_factor) outputs:()
			   		// linked node: tMap_2 - inputs:(extract_diagnosis,join_factor) outputs:(load_diagnosis)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_join_factor = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_factorStruct> tHash_Lookup_join_factor =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<join_factorStruct>getLookup(matchingModeEnum_join_factor);
	   						   
		   	   	   globalMap.put("tHash_Lookup_join_factor", tHash_Lookup_join_factor);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_join_factor begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "loga";
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:0oYa/bf2WQrPMPZSC9d3eidAXN757k4rsykdaYaCkIyELGO4");
				
				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;
				
				String url_tDBInput_5 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5,dbUser_tDBInput_5,dbPwd_tDBInput_5);
		        
				conn_tDBInput_5.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "select id, entity, dysfunction, maintenance,diagnosis from factor";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								join_factor.id = null;
							} else {
		                          
            join_factor.id = rs_tDBInput_5.getLong(1);
            if(rs_tDBInput_5.wasNull()){
                    join_factor.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								join_factor.entity = null;
							} else {
	                         		
        	join_factor.entity = routines.system.JDBCUtil.getString(rs_tDBInput_5, 2, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								join_factor.dysfunction = null;
							} else {
	                         		
        	join_factor.dysfunction = routines.system.JDBCUtil.getString(rs_tDBInput_5, 3, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								join_factor.maintenance = null;
							} else {
	                         		
        	join_factor.maintenance = routines.system.JDBCUtil.getString(rs_tDBInput_5, 4, false);
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								join_factor.diagnosis = null;
							} else {
		                          
            join_factor.diagnosis = rs_tDBInput_5.getLong(5);
            if(rs_tDBInput_5.wasNull()){
                    join_factor.diagnosis = null;
            }
		                    }
					


 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_join_factor main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_factor";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"join_factor"
						
						);
					}
					


			   
			   

					join_factorStruct join_factor_HashRow = new join_factorStruct();
		   	   	   
				
				join_factor_HashRow.id = join_factor.id;
				
				join_factor_HashRow.entity = join_factor.entity;
				
				join_factor_HashRow.dysfunction = join_factor.dysfunction;
				
				join_factor_HashRow.maintenance = join_factor.maintenance;
				
				join_factor_HashRow.diagnosis = join_factor.diagnosis;
				
			tHash_Lookup_join_factor.put(join_factor_HashRow);
			
            




 


	tos_count_tAdvancedHash_join_factor++;

/**
 * [tAdvancedHash_join_factor main ] stop
 */
	
	/**
	 * [tAdvancedHash_join_factor process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_factor";

	

 



/**
 * [tAdvancedHash_join_factor process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_join_factor process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_factor";

	

 



/**
 * [tAdvancedHash_join_factor process_data_end ] stop
 */



	
	/**
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
	if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
		
			conn_tDBInput_5.commit();
			
		
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);
 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_join_factor end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_factor";

	

tHash_Lookup_join_factor.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"join_factor");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_join_factor", true);
end_Hash.put("tAdvancedHash_join_factor", System.currentTimeMillis());




/**
 * [tAdvancedHash_join_factor end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_join_factor finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_factor";

	

 



/**
 * [tAdvancedHash_join_factor finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class load_spareStruct implements routines.system.IPersistableRow<load_spareStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer pk_spare;

				public Integer getPk_spare () {
					return this.pk_spare;
				}
				
			    public java.util.Date period;

				public java.util.Date getPeriod () {
					return this.period;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public String spare;

				public String getSpare () {
					return this.spare;
				}
				
			    public Integer price;

				public Integer getPrice () {
					return this.price;
				}
				
			    public Integer quantity;

				public Integer getQuantity () {
					return this.quantity;
				}
				
			    public Integer amount;

				public Integer getAmount () {
					return this.amount;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.pk_spare == null) ? 0 : this.pk_spare.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final load_spareStruct other = (load_spareStruct) obj;
		
						if (this.pk_spare == null) {
							if (other.pk_spare != null)
								return false;
						
						} else if (!this.pk_spare.equals(other.pk_spare))
						
							return false;
					

		return true;
    }

	public void copyDataTo(load_spareStruct other) {

		other.pk_spare = this.pk_spare;
	            other.period = this.period;
	            other.description = this.description;
	            other.dossier = this.dossier;
	            other.is_approved = this.is_approved;
	            other.mileage = this.mileage;
	            other.reference = this.reference;
	            other.spare = this.spare;
	            other.price = this.price;
	            other.quantity = this.quantity;
	            other.amount = this.amount;
	            
	}

	public void copyKeysDataTo(load_spareStruct other) {

		other.pk_spare = this.pk_spare;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_spare = readInteger(dis);
					
					this.period = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
					this.spare = readString(dis);
					
						this.price = readInteger(dis);
					
						this.quantity = readInteger(dis);
					
						this.amount = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_spare = readInteger(dis);
					
					this.period = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
					this.spare = readString(dis);
					
						this.price = readInteger(dis);
					
						this.quantity = readInteger(dis);
					
						this.amount = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_spare,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.spare,dos);
					
					// Integer
				
						writeInteger(this.price,dos);
					
					// Integer
				
						writeInteger(this.quantity,dos);
					
					// Integer
				
						writeInteger(this.amount,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_spare,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.spare,dos);
					
					// Integer
				
						writeInteger(this.price,dos);
					
					// Integer
				
						writeInteger(this.quantity,dos);
					
					// Integer
				
						writeInteger(this.amount,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("pk_spare="+String.valueOf(pk_spare));
		sb.append(",period="+String.valueOf(period));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
		sb.append(",spare="+spare);
		sb.append(",price="+String.valueOf(price));
		sb.append(",quantity="+String.valueOf(quantity));
		sb.append(",amount="+String.valueOf(amount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(load_spareStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.pk_spare, other.pk_spare);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class extract_repairStruct implements routines.system.IPersistableRow<extract_repairStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(extract_repairStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_6Struct implements routines.system.IPersistableRow<after_tDBInput_6Struct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_6Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_7Process(globalMap);

		extract_repairStruct extract_repair = new extract_repairStruct();
load_spareStruct load_spare = new load_spareStruct();





	
	/**
	 * [tDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_3", false);
		start_Hash.put("tDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"load_spare");
					}
				
		int tos_count_tDBOutput_3 = 0;
		





String dbschema_tDBOutput_3 = null;
	dbschema_tDBOutput_3 = "";
	

String tableName_tDBOutput_3 = null;
if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
	tableName_tDBOutput_3 = ("fact_spares");
} else {
	tableName_tDBOutput_3 = dbschema_tDBOutput_3 + "\".\"" + ("fact_spares");
}

        int updateKeyCount_tDBOutput_3 = 1;
        if(updateKeyCount_tDBOutput_3 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_3 == 11 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_3 = 0;
int nb_line_update_tDBOutput_3 = 0;
int nb_line_inserted_tDBOutput_3 = 0;
int nb_line_deleted_tDBOutput_3 = 0;
int nb_line_rejected_tDBOutput_3 = 0;

int deletedCount_tDBOutput_3=0;
int updatedCount_tDBOutput_3=0;
int insertedCount_tDBOutput_3=0;
int rowsToCommitCount_tDBOutput_3=0;
int rejectedCount_tDBOutput_3=0;

boolean whetherReject_tDBOutput_3 = false;

java.sql.Connection conn_tDBOutput_3 = null;
String dbUser_tDBOutput_3 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_3 = "jdbc:postgresql://"+"172.19.0.3"+":"+"5432"+"/"+"loga";
    dbUser_tDBOutput_3 = "loga";
 
	final String decryptedPassword_tDBOutput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:p0ZudaIqYcviDHCbui+AH0pRCnwupKtytfgNmzXI6VA53/Uw");

    String dbPwd_tDBOutput_3 = decryptedPassword_tDBOutput_3;

    conn_tDBOutput_3 = java.sql.DriverManager.getConnection(url_tDBOutput_3,dbUser_tDBOutput_3,dbPwd_tDBOutput_3);
	
	resourceMap.put("conn_tDBOutput_3", conn_tDBOutput_3);
        conn_tDBOutput_3.setAutoCommit(false);
        int commitEvery_tDBOutput_3 = 10000;
        int commitCounter_tDBOutput_3 = 0;



int count_tDBOutput_3=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_3 = conn_tDBOutput_3.getMetaData();
                                boolean whetherExist_tDBOutput_3 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_3 = dbMetaData_tDBOutput_3.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_3 = "public";
                                    if(dbschema_tDBOutput_3 == null || dbschema_tDBOutput_3.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_3 = conn_tDBOutput_3.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_3 = stmtSchema_tDBOutput_3.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_3.next()){
                                                defaultSchema_tDBOutput_3 = rsSchema_tDBOutput_3.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_3.next()) {
                                        String table_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_NAME");
                                        String schema_tDBOutput_3 = rsTable_tDBOutput_3.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_3.equals(("fact_spares"))
                                            && (schema_tDBOutput_3.equals(dbschema_tDBOutput_3) || ((dbschema_tDBOutput_3 ==null || dbschema_tDBOutput_3.trim().length() ==0) && defaultSchema_tDBOutput_3.equals(schema_tDBOutput_3)))) {
                                            whetherExist_tDBOutput_3 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_3) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_3 = conn_tDBOutput_3.createStatement()) {
                                        stmtCreate_tDBOutput_3.execute("CREATE TABLE \"" + tableName_tDBOutput_3 + "\"(\"pk_spare\" INT4 ,\"period\" TIMESTAMP ,\"description\" VARCHAR ,\"dossier\" VARCHAR ,\"is_approved\" BOOL ,\"mileage\" INT4 ,\"reference\" VARCHAR ,\"spare\" VARCHAR ,\"price\" INT4 ,\"quantity\" INT4 ,\"amount\" INT4 ,primary key(\"pk_spare\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_3 = conn_tDBOutput_3.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_3 + "\" WHERE \"pk_spare\" = ?");
	    resourceMap.put("pstmt_tDBOutput_3", pstmt_tDBOutput_3);
	    String insert_tDBOutput_3 = "INSERT INTO \"" + tableName_tDBOutput_3 + "\" (\"pk_spare\",\"period\",\"description\",\"dossier\",\"is_approved\",\"mileage\",\"reference\",\"spare\",\"price\",\"quantity\",\"amount\") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(insert_tDBOutput_3);
	    resourceMap.put("pstmtInsert_tDBOutput_3", pstmtInsert_tDBOutput_3);
	    String update_tDBOutput_3 = "UPDATE \"" + tableName_tDBOutput_3 + "\" SET \"period\" = ?,\"description\" = ?,\"dossier\" = ?,\"is_approved\" = ?,\"mileage\" = ?,\"reference\" = ?,\"spare\" = ?,\"price\" = ?,\"quantity\" = ?,\"amount\" = ? WHERE \"pk_spare\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_3 = conn_tDBOutput_3.prepareStatement(update_tDBOutput_3);
	    resourceMap.put("pstmtUpdate_tDBOutput_3", pstmtUpdate_tDBOutput_3);
	    

 



/**
 * [tDBOutput_3 begin ] stop
 */



	
	/**
	 * [tMap_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_3", false);
		start_Hash.put("tMap_3", System.currentTimeMillis());
		
	
	currentComponent="tMap_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"extract_repair");
					}
				
		int tos_count_tMap_3 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_spareStruct> tHash_Lookup_join_spare = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_spareStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_spareStruct>) 
					globalMap.get( "tHash_Lookup_join_spare" ))
					;					
					
	

join_spareStruct join_spareHashKey = new join_spareStruct();
join_spareStruct join_spareDefault = new join_spareStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_3__Struct  {
}
Var__tMap_3__Struct Var__tMap_3 = new Var__tMap_3__Struct();
// ###############################

// ###############################
// # Outputs initialization
load_spareStruct load_spare_tmp = new load_spareStruct();
// ###############################

        
        



        









 



/**
 * [tMap_3 begin ] stop
 */



	
	/**
	 * [tDBInput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_6", false);
		start_Hash.put("tDBInput_6", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_6";

	
		int tos_count_tDBInput_6 = 0;
		
	
    
	
		    int nb_line_tDBInput_6 = 0;
		    java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "loga";
				
				 
	final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:0lV6NLzCb/bIrWe2Ev5IH+c90GWWGYMRLinveN63QS+sCuJ6");
				
				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;
				
				String url_tDBInput_6 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6,dbUser_tDBInput_6,dbPwd_tDBInput_6);
		        
				conn_tDBInput_6.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

		    String dbquery_tDBInput_6 = "select \nid,\ncreated_at,\ndescription,\ndossier,\nis_approved,\nmileage,\nreference\nfrom repair";
		    

            	globalMap.put("tDBInput_6_QUERY",dbquery_tDBInput_6);
		    java.sql.ResultSet rs_tDBInput_6 = null;

		    try {
		    	rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
		    	int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

		    String tmpContent_tDBInput_6 = null;
		    
		    
		    while (rs_tDBInput_6.next()) {
		        nb_line_tDBInput_6++;
		        
							if(colQtyInRs_tDBInput_6 < 1) {
								extract_repair.id = null;
							} else {
		                          
            extract_repair.id = rs_tDBInput_6.getLong(1);
            if(rs_tDBInput_6.wasNull()){
                    extract_repair.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 2) {
								extract_repair.created_at = null;
							} else {
										
			extract_repair.created_at = routines.system.JDBCUtil.getDate(rs_tDBInput_6, 2);
		                    }
							if(colQtyInRs_tDBInput_6 < 3) {
								extract_repair.description = null;
							} else {
	                         		
        	extract_repair.description = routines.system.JDBCUtil.getString(rs_tDBInput_6, 3, false);
		                    }
							if(colQtyInRs_tDBInput_6 < 4) {
								extract_repair.dossier = null;
							} else {
	                         		
        	extract_repair.dossier = routines.system.JDBCUtil.getString(rs_tDBInput_6, 4, false);
		                    }
							if(colQtyInRs_tDBInput_6 < 5) {
								extract_repair.is_approved = null;
							} else {
	                         		
            extract_repair.is_approved = rs_tDBInput_6.getBoolean(5);
            if(rs_tDBInput_6.wasNull()){
                    extract_repair.is_approved = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 6) {
								extract_repair.mileage = null;
							} else {
		                          
            extract_repair.mileage = rs_tDBInput_6.getInt(6);
            if(rs_tDBInput_6.wasNull()){
                    extract_repair.mileage = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 7) {
								extract_repair.reference = null;
							} else {
	                         		
        	extract_repair.reference = routines.system.JDBCUtil.getString(rs_tDBInput_6, 7, false);
		                    }
					


 



/**
 * [tDBInput_6 begin ] stop
 */
	
	/**
	 * [tDBInput_6 main ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 


	tos_count_tDBInput_6++;

/**
 * [tDBInput_6 main ] stop
 */
	
	/**
	 * [tDBInput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_begin ] stop
 */

	
	/**
	 * [tMap_3 main ] start
	 */

	

	
	
	currentComponent="tMap_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"extract_repair"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_3 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_3 = false;
		  boolean mainRowRejected_tMap_3 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "join_spare" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopjoin_spare = false;
       		  	    	
       		  	    	
 							join_spareStruct join_spareObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_3) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_3 = false;
								
                        		    		    join_spareHashKey.repair = extract_repair.id;
                        		    		

								
		                        	join_spareHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_join_spare.lookup( join_spareHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_join_spare.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLoopjoin_spare = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopjoin_spare = true;
			           		  	} // G 21
                    		  	
                    		

							join_spareStruct join_spare = null;
                    		  	 
							

								while ((tHash_Lookup_join_spare != null && tHash_Lookup_join_spare.hasNext()) || forceLoopjoin_spare) { // G_TM_M_043

								
									 // CALL close loop of lookup 'join_spare'
									
                    		  	 
							   
                    		  	 
	       		  	    	join_spareStruct fromLookup_join_spare = null;
							join_spare = join_spareDefault;
										 
							
								
								if(!forceLoopjoin_spare) { // G 46
								
							
								 
							
								
								fromLookup_join_spare = tHash_Lookup_join_spare.next();

							

							if(fromLookup_join_spare != null) {
								join_spare = fromLookup_join_spare;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopjoin_spare = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_3__Struct Var = Var__tMap_3;// ###############################
        // ###############################
        // # Output tables

load_spare = null;


// # Output table : 'load_spare'
load_spare_tmp.pk_spare = Numeric.sequence("s1",1,1) ;
load_spare_tmp.period = extract_repair.created_at ;
load_spare_tmp.description = extract_repair.description ;
load_spare_tmp.dossier = extract_repair.dossier ;
load_spare_tmp.is_approved = extract_repair.is_approved ;
load_spare_tmp.mileage = extract_repair.mileage ;
load_spare_tmp.reference = extract_repair.reference ;
load_spare_tmp.spare = join_spare.designation ;
load_spare_tmp.price = join_spare.price ;
load_spare_tmp.quantity = join_spare.quantity ;
load_spare_tmp.amount = join_spare.amount ;
load_spare = load_spare_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_3 = false;










 


	tos_count_tMap_3++;

/**
 * [tMap_3 main ] stop
 */
	
	/**
	 * [tMap_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_begin ] stop
 */
// Start of branch "load_spare"
if(load_spare != null) { 



	
	/**
	 * [tDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"load_spare"
						
						);
					}
					



        whetherReject_tDBOutput_3 = false;
                    if(load_spare.pk_spare == null) {
pstmt_tDBOutput_3.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_3.setInt(1, load_spare.pk_spare);
}

            int checkCount_tDBOutput_3 = -1;
            try (java.sql.ResultSet rs_tDBOutput_3 = pstmt_tDBOutput_3.executeQuery()) {
                while(rs_tDBOutput_3.next()) {
                    checkCount_tDBOutput_3 = rs_tDBOutput_3.getInt(1);
                }
            }
            if(checkCount_tDBOutput_3 > 0) {
                        if(load_spare.period != null) {
pstmtUpdate_tDBOutput_3.setTimestamp(1, new java.sql.Timestamp(load_spare.period.getTime()));
} else {
pstmtUpdate_tDBOutput_3.setNull(1, java.sql.Types.TIMESTAMP);
}

                        if(load_spare.description == null) {
pstmtUpdate_tDBOutput_3.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(2, load_spare.description);
}

                        if(load_spare.dossier == null) {
pstmtUpdate_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(3, load_spare.dossier);
}

                        if(load_spare.is_approved == null) {
pstmtUpdate_tDBOutput_3.setNull(4, java.sql.Types.BOOLEAN);
} else {pstmtUpdate_tDBOutput_3.setBoolean(4, load_spare.is_approved);
}

                        if(load_spare.mileage == null) {
pstmtUpdate_tDBOutput_3.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(5, load_spare.mileage);
}

                        if(load_spare.reference == null) {
pstmtUpdate_tDBOutput_3.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(6, load_spare.reference);
}

                        if(load_spare.spare == null) {
pstmtUpdate_tDBOutput_3.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_3.setString(7, load_spare.spare);
}

                        if(load_spare.price == null) {
pstmtUpdate_tDBOutput_3.setNull(8, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(8, load_spare.price);
}

                        if(load_spare.quantity == null) {
pstmtUpdate_tDBOutput_3.setNull(9, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(9, load_spare.quantity);
}

                        if(load_spare.amount == null) {
pstmtUpdate_tDBOutput_3.setNull(10, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(10, load_spare.amount);
}

                        if(load_spare.pk_spare == null) {
pstmtUpdate_tDBOutput_3.setNull(11 + count_tDBOutput_3, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_3.setInt(11 + count_tDBOutput_3, load_spare.pk_spare);
}

                try {
					
                    int processedCount_tDBOutput_3 = pstmtUpdate_tDBOutput_3.executeUpdate();
                    updatedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_3 = true;
                        nb_line_tDBOutput_3++;
                            System.err.print(e.getMessage());
                }
            } else {
                        if(load_spare.pk_spare == null) {
pstmtInsert_tDBOutput_3.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(1, load_spare.pk_spare);
}

                        if(load_spare.period != null) {
pstmtInsert_tDBOutput_3.setTimestamp(2, new java.sql.Timestamp(load_spare.period.getTime()));
} else {
pstmtInsert_tDBOutput_3.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(load_spare.description == null) {
pstmtInsert_tDBOutput_3.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(3, load_spare.description);
}

                        if(load_spare.dossier == null) {
pstmtInsert_tDBOutput_3.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(4, load_spare.dossier);
}

                        if(load_spare.is_approved == null) {
pstmtInsert_tDBOutput_3.setNull(5, java.sql.Types.BOOLEAN);
} else {pstmtInsert_tDBOutput_3.setBoolean(5, load_spare.is_approved);
}

                        if(load_spare.mileage == null) {
pstmtInsert_tDBOutput_3.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(6, load_spare.mileage);
}

                        if(load_spare.reference == null) {
pstmtInsert_tDBOutput_3.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(7, load_spare.reference);
}

                        if(load_spare.spare == null) {
pstmtInsert_tDBOutput_3.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_3.setString(8, load_spare.spare);
}

                        if(load_spare.price == null) {
pstmtInsert_tDBOutput_3.setNull(9, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(9, load_spare.price);
}

                        if(load_spare.quantity == null) {
pstmtInsert_tDBOutput_3.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(10, load_spare.quantity);
}

                        if(load_spare.amount == null) {
pstmtInsert_tDBOutput_3.setNull(11, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_3.setInt(11, load_spare.amount);
}

                try {
					
                    int processedCount_tDBOutput_3 = pstmtInsert_tDBOutput_3.executeUpdate();
                    insertedCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    rowsToCommitCount_tDBOutput_3 += processedCount_tDBOutput_3;
                    nb_line_tDBOutput_3++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_3_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_3 = true;
                        nb_line_tDBOutput_3++;
                            System.err.print(e.getMessage());
                }
            }
    		    commitCounter_tDBOutput_3++;
                if(commitEvery_tDBOutput_3 <= commitCounter_tDBOutput_3) {
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                    	
                    }
                    conn_tDBOutput_3.commit();
                    if(rowsToCommitCount_tDBOutput_3 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_3 = 0;
                    }
                    commitCounter_tDBOutput_3=0;
                }

 


	tos_count_tDBOutput_3++;

/**
 * [tDBOutput_3 main ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	

 



/**
 * [tDBOutput_3 process_data_end ] stop
 */

} // End of branch "load_spare"



	
		} // close loop of lookup 'join_spare' // G_TM_M_043
	
	
	/**
	 * [tMap_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_6 end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

	}
}finally{
	if (rs_tDBInput_6 != null) {
		rs_tDBInput_6.close();
	}
	if (stmt_tDBInput_6 != null) {
		stmt_tDBInput_6.close();
	}
	if(conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {
		
			conn_tDBInput_6.commit();
			
		
			conn_tDBInput_6.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_6_NB_LINE",nb_line_tDBInput_6);
 

ok_Hash.put("tDBInput_6", true);
end_Hash.put("tDBInput_6", System.currentTimeMillis());




/**
 * [tDBInput_6 end ] stop
 */

	
	/**
	 * [tMap_3 end ] start
	 */

	

	
	
	currentComponent="tMap_3";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_join_spare != null) {
						tHash_Lookup_join_spare.endGet();
					}
					globalMap.remove( "tHash_Lookup_join_spare" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"extract_repair");
			  	}
			  	
 

ok_Hash.put("tMap_3", true);
end_Hash.put("tMap_3", System.currentTimeMillis());




/**
 * [tMap_3 end ] stop
 */

	
	/**
	 * [tDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



        if(pstmtUpdate_tDBOutput_3 != null){
            pstmtUpdate_tDBOutput_3.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_3");
        }
        if(pstmtInsert_tDBOutput_3 != null){
            pstmtInsert_tDBOutput_3.close();
            resourceMap.remove("pstmtInsert_tDBOutput_3");
        }
        if(pstmt_tDBOutput_3 != null) {
            pstmt_tDBOutput_3.close();
            resourceMap.remove("pstmt_tDBOutput_3");
        }
    resourceMap.put("statementClosed_tDBOutput_3", true);
			if(rowsToCommitCount_tDBOutput_3 != 0){
				
			}
			conn_tDBOutput_3.commit();
			if(rowsToCommitCount_tDBOutput_3 != 0){
				
				rowsToCommitCount_tDBOutput_3 = 0;
			}
			commitCounter_tDBOutput_3 = 0;
		
    	conn_tDBOutput_3 .close();
    	
    	resourceMap.put("finish_tDBOutput_3", true);
    	

	nb_line_deleted_tDBOutput_3=nb_line_deleted_tDBOutput_3+ deletedCount_tDBOutput_3;
	nb_line_update_tDBOutput_3=nb_line_update_tDBOutput_3 + updatedCount_tDBOutput_3;
	nb_line_inserted_tDBOutput_3=nb_line_inserted_tDBOutput_3 + insertedCount_tDBOutput_3;
	nb_line_rejected_tDBOutput_3=nb_line_rejected_tDBOutput_3 + rejectedCount_tDBOutput_3;
	
        globalMap.put("tDBOutput_3_NB_LINE",nb_line_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_UPDATED",nb_line_update_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_DELETED",nb_line_deleted_tDBOutput_3);
        globalMap.put("tDBOutput_3_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_3);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"load_spare");
			  	}
			  	
 

ok_Hash.put("tDBOutput_3", true);
end_Hash.put("tDBOutput_3", System.currentTimeMillis());




/**
 * [tDBOutput_3 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_3"
					     			globalMap.remove("tHash_Lookup_join_spare"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_6 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 finally ] stop
 */

	
	/**
	 * [tMap_3 finally ] start
	 */

	

	
	
	currentComponent="tMap_3";

	

 



/**
 * [tMap_3 finally ] stop
 */

	
	/**
	 * [tDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_3";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_3") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_3 = null;
                if ((pstmtUpdateToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_3")) != null) {
                    pstmtUpdateToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_3 = null;
                if ((pstmtInsertToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_3")) != null) {
                    pstmtInsertToClose_tDBOutput_3.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_3 = null;
                if ((pstmtToClose_tDBOutput_3 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_3")) != null) {
                    pstmtToClose_tDBOutput_3.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_3") == null){
            java.sql.Connection ctn_tDBOutput_3 = null;
            if((ctn_tDBOutput_3 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_3")) != null){
                try {
                    ctn_tDBOutput_3.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_3) {
                    String errorMessage_tDBOutput_3 = "failed to close the connection in tDBOutput_3 :" + sqlEx_tDBOutput_3.getMessage();
                    System.err.println(errorMessage_tDBOutput_3);
                }
            }
        }
    }
 



/**
 * [tDBOutput_3 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}
	


public static class join_spareStruct implements routines.system.IPersistableComparableLookupRow<join_spareStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String designation;

				public String getDesignation () {
					return this.designation;
				}
				
			    public Integer price;

				public Integer getPrice () {
					return this.price;
				}
				
			    public Integer quantity;

				public Integer getQuantity () {
					return this.quantity;
				}
				
			    public Integer amount;

				public Integer getAmount () {
					return this.amount;
				}
				
			    public Long repair;

				public Long getRepair () {
					return this.repair;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.repair == null) ? 0 : this.repair.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final join_spareStruct other = (join_spareStruct) obj;
		
						if (this.repair == null) {
							if (other.repair != null)
								return false;
						
						} else if (!this.repair.equals(other.repair))
						
							return false;
					

		return true;
    }

	public void copyDataTo(join_spareStruct other) {

		other.id = this.id;
	            other.designation = this.designation;
	            other.price = this.price;
	            other.quantity = this.quantity;
	            other.amount = this.amount;
	            other.repair = this.repair;
	            
	}

	public void copyKeysDataTo(join_spareStruct other) {

		other.repair = this.repair;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.repair = null;
           				} else {
           			    	this.repair = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.repair = null;
           				} else {
           			    	this.repair = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.repair == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.repair);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.repair == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.repair);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
						this.designation = readString(dis,ois);
					
						this.price = readInteger(dis,ois);
					
						this.quantity = readInteger(dis,ois);
					
						this.amount = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = objectIn.readLong();
           				}
					
						this.designation = readString(dis,objectIn);
					
						this.price = readInteger(dis,objectIn);
					
						this.quantity = readInteger(dis,objectIn);
					
						this.amount = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
						writeString(this.designation, dos, oos);
					
					writeInteger(this.price, dos, oos);
					
					writeInteger(this.quantity, dos, oos);
					
					writeInteger(this.amount, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.id);
		            	}
					
						writeString(this.designation, dos, objectOut);
					
					writeInteger(this.price, dos, objectOut);
					
					writeInteger(this.quantity, dos, objectOut);
					
					writeInteger(this.amount, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",designation="+designation);
		sb.append(",price="+String.valueOf(price));
		sb.append(",quantity="+String.valueOf(quantity));
		sb.append(",amount="+String.valueOf(amount));
		sb.append(",repair="+String.valueOf(repair));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(join_spareStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.repair, other.repair);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		join_spareStruct join_spare = new join_spareStruct();




	
	/**
	 * [tAdvancedHash_join_spare begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_join_spare", false);
		start_Hash.put("tAdvancedHash_join_spare", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_join_spare";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"join_spare");
					}
				
		int tos_count_tAdvancedHash_join_spare = 0;
		

			   		// connection name:join_spare
			   		// source node:tDBInput_7 - inputs:(after_tDBInput_6) outputs:(join_spare,join_spare) | target node:tAdvancedHash_join_spare - inputs:(join_spare) outputs:()
			   		// linked node: tMap_3 - inputs:(extract_repair,join_spare) outputs:(load_spare)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_join_spare = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_spareStruct> tHash_Lookup_join_spare =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<join_spareStruct>getLookup(matchingModeEnum_join_spare);
	   						   
		   	   	   globalMap.put("tHash_Lookup_join_spare", tHash_Lookup_join_spare);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_join_spare begin ] stop
 */



	
	/**
	 * [tDBInput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_7", false);
		start_Hash.put("tDBInput_7", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_7";

	
		int tos_count_tDBInput_7 = 0;
		
	
    
	
		    int nb_line_tDBInput_7 = 0;
		    java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = "loga";
				
				 
	final String decryptedPassword_tDBInput_7 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:5yRbthWb2hCFw/n1tM8KMMY/RfImUhuHbpFiLClOtJkaaFKd");
				
				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;
				
				String url_tDBInput_7 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7,dbUser_tDBInput_7,dbPwd_tDBInput_7);
		        
				conn_tDBInput_7.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

		    String dbquery_tDBInput_7 = "select id,designation,price,quantity,amount,repair from spare";
		    

            	globalMap.put("tDBInput_7_QUERY",dbquery_tDBInput_7);
		    java.sql.ResultSet rs_tDBInput_7 = null;

		    try {
		    	rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
		    	int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

		    String tmpContent_tDBInput_7 = null;
		    
		    
		    while (rs_tDBInput_7.next()) {
		        nb_line_tDBInput_7++;
		        
							if(colQtyInRs_tDBInput_7 < 1) {
								join_spare.id = null;
							} else {
		                          
            join_spare.id = rs_tDBInput_7.getLong(1);
            if(rs_tDBInput_7.wasNull()){
                    join_spare.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 2) {
								join_spare.designation = null;
							} else {
	                         		
        	join_spare.designation = routines.system.JDBCUtil.getString(rs_tDBInput_7, 2, false);
		                    }
							if(colQtyInRs_tDBInput_7 < 3) {
								join_spare.price = null;
							} else {
		                          
            join_spare.price = rs_tDBInput_7.getInt(3);
            if(rs_tDBInput_7.wasNull()){
                    join_spare.price = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 4) {
								join_spare.quantity = null;
							} else {
		                          
            join_spare.quantity = rs_tDBInput_7.getInt(4);
            if(rs_tDBInput_7.wasNull()){
                    join_spare.quantity = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 5) {
								join_spare.amount = null;
							} else {
		                          
            join_spare.amount = rs_tDBInput_7.getInt(5);
            if(rs_tDBInput_7.wasNull()){
                    join_spare.amount = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 6) {
								join_spare.repair = null;
							} else {
		                          
            join_spare.repair = rs_tDBInput_7.getLong(6);
            if(rs_tDBInput_7.wasNull()){
                    join_spare.repair = null;
            }
		                    }
					


 



/**
 * [tDBInput_7 begin ] stop
 */
	
	/**
	 * [tDBInput_7 main ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 


	tos_count_tDBInput_7++;

/**
 * [tDBInput_7 main ] stop
 */
	
	/**
	 * [tDBInput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_join_spare main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_spare";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"join_spare"
						
						);
					}
					


			   
			   

					join_spareStruct join_spare_HashRow = new join_spareStruct();
		   	   	   
				
				join_spare_HashRow.id = join_spare.id;
				
				join_spare_HashRow.designation = join_spare.designation;
				
				join_spare_HashRow.price = join_spare.price;
				
				join_spare_HashRow.quantity = join_spare.quantity;
				
				join_spare_HashRow.amount = join_spare.amount;
				
				join_spare_HashRow.repair = join_spare.repair;
				
			tHash_Lookup_join_spare.put(join_spare_HashRow);
			
            




 


	tos_count_tAdvancedHash_join_spare++;

/**
 * [tAdvancedHash_join_spare main ] stop
 */
	
	/**
	 * [tAdvancedHash_join_spare process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_spare";

	

 



/**
 * [tAdvancedHash_join_spare process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_join_spare process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_spare";

	

 



/**
 * [tAdvancedHash_join_spare process_data_end ] stop
 */



	
	/**
	 * [tDBInput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_7 end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

	}
}finally{
	if (rs_tDBInput_7 != null) {
		rs_tDBInput_7.close();
	}
	if (stmt_tDBInput_7 != null) {
		stmt_tDBInput_7.close();
	}
	if(conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {
		
			conn_tDBInput_7.commit();
			
		
			conn_tDBInput_7.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_7_NB_LINE",nb_line_tDBInput_7);
 

ok_Hash.put("tDBInput_7", true);
end_Hash.put("tDBInput_7", System.currentTimeMillis());




/**
 * [tDBInput_7 end ] stop
 */

	
	/**
	 * [tAdvancedHash_join_spare end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_spare";

	

tHash_Lookup_join_spare.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"join_spare");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_join_spare", true);
end_Hash.put("tAdvancedHash_join_spare", System.currentTimeMillis());




/**
 * [tAdvancedHash_join_spare end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_7 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_join_spare finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_spare";

	

 



/**
 * [tAdvancedHash_join_spare finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}
	


public static class copyOfload_repairStruct implements routines.system.IPersistableRow<copyOfload_repairStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer pk_task;

				public Integer getPk_task () {
					return this.pk_task;
				}
				
			    public java.util.Date period;

				public java.util.Date getPeriod () {
					return this.period;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				
			    public String task;

				public String getTask () {
					return this.task;
				}
				
			    public Integer duration;

				public Integer getDuration () {
					return this.duration;
				}
				
			    public Integer cost;

				public Integer getCost () {
					return this.cost;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.pk_task == null) ? 0 : this.pk_task.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final copyOfload_repairStruct other = (copyOfload_repairStruct) obj;
		
						if (this.pk_task == null) {
							if (other.pk_task != null)
								return false;
						
						} else if (!this.pk_task.equals(other.pk_task))
						
							return false;
					

		return true;
    }

	public void copyDataTo(copyOfload_repairStruct other) {

		other.pk_task = this.pk_task;
	            other.period = this.period;
	            other.description = this.description;
	            other.dossier = this.dossier;
	            other.is_approved = this.is_approved;
	            other.mileage = this.mileage;
	            other.reference = this.reference;
	            other.task = this.task;
	            other.duration = this.duration;
	            other.cost = this.cost;
	            
	}

	public void copyKeysDataTo(copyOfload_repairStruct other) {

		other.pk_task = this.pk_task;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_task = readInteger(dis);
					
					this.period = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
					this.task = readString(dis);
					
						this.duration = readInteger(dis);
					
						this.cost = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
						this.pk_task = readInteger(dis);
					
					this.period = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
					this.task = readString(dis);
					
						this.duration = readInteger(dis);
					
						this.cost = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_task,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.task,dos);
					
					// Integer
				
						writeInteger(this.duration,dos);
					
					// Integer
				
						writeInteger(this.cost,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.pk_task,dos);
					
					// java.util.Date
				
						writeDate(this.period,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
					// String
				
						writeString(this.task,dos);
					
					// Integer
				
						writeInteger(this.duration,dos);
					
					// Integer
				
						writeInteger(this.cost,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("pk_task="+String.valueOf(pk_task));
		sb.append(",period="+String.valueOf(period));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
		sb.append(",task="+task);
		sb.append(",duration="+String.valueOf(duration));
		sb.append(",cost="+String.valueOf(cost));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(copyOfload_repairStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.pk_task, other.pk_task);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_8Struct implements routines.system.IPersistableRow<after_tDBInput_8Struct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];

	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public java.util.Date created_at;

				public java.util.Date getCreated_at () {
					return this.created_at;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public String dossier;

				public String getDossier () {
					return this.dossier;
				}
				
			    public Boolean is_approved;

				public Boolean getIs_approved () {
					return this.is_approved;
				}
				
			    public Integer mileage;

				public Integer getMileage () {
					return this.mileage;
				}
				
			    public String reference;

				public String getReference () {
					return this.reference;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TFE_MASTER_tfe_master.length) {
				if(length < 1024 && commonByteArray_TFE_MASTER_tfe_master.length == 0) {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[1024];
				} else {
   					commonByteArray_TFE_MASTER_tfe_master = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TFE_MASTER_tfe_master, 0, length);
			strReturn = new String(commonByteArray_TFE_MASTER_tfe_master, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
					this.created_at = readDate(dis);
					
					this.description = readString(dis);
					
					this.dossier = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_approved = null;
           				} else {
           			    	this.is_approved = dis.readBoolean();
           				}
					
						this.mileage = readInteger(dis);
					
					this.reference = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
					// java.util.Date
				
						writeDate(this.created_at,dos);
					
					// String
				
						writeString(this.description,dos);
					
					// String
				
						writeString(this.dossier,dos);
					
					// Boolean
				
						if(this.is_approved == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_approved);
		            	}
					
					// Integer
				
						writeInteger(this.mileage,dos);
					
					// String
				
						writeString(this.reference,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",created_at="+String.valueOf(created_at));
		sb.append(",description="+description);
		sb.append(",dossier="+dossier);
		sb.append(",is_approved="+String.valueOf(is_approved));
		sb.append(",mileage="+String.valueOf(mileage));
		sb.append(",reference="+reference);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_8Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_9Process(globalMap);

		row1Struct row1 = new row1Struct();
copyOfload_repairStruct copyOfload_repair = new copyOfload_repairStruct();





	
	/**
	 * [tDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_4", false);
		start_Hash.put("tDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"copyOfload_repair");
					}
				
		int tos_count_tDBOutput_4 = 0;
		





String dbschema_tDBOutput_4 = null;
	dbschema_tDBOutput_4 = "";
	

String tableName_tDBOutput_4 = null;
if(dbschema_tDBOutput_4 == null || dbschema_tDBOutput_4.trim().length() == 0) {
	tableName_tDBOutput_4 = ("fact_tasks");
} else {
	tableName_tDBOutput_4 = dbschema_tDBOutput_4 + "\".\"" + ("fact_tasks");
}

        int updateKeyCount_tDBOutput_4 = 1;
        if(updateKeyCount_tDBOutput_4 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_4 == 10 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_4 = 0;
int nb_line_update_tDBOutput_4 = 0;
int nb_line_inserted_tDBOutput_4 = 0;
int nb_line_deleted_tDBOutput_4 = 0;
int nb_line_rejected_tDBOutput_4 = 0;

int deletedCount_tDBOutput_4=0;
int updatedCount_tDBOutput_4=0;
int insertedCount_tDBOutput_4=0;
int rowsToCommitCount_tDBOutput_4=0;
int rejectedCount_tDBOutput_4=0;

boolean whetherReject_tDBOutput_4 = false;

java.sql.Connection conn_tDBOutput_4 = null;
String dbUser_tDBOutput_4 = null;

	
    java.lang.Class.forName("org.postgresql.Driver");
    
        String url_tDBOutput_4 = "jdbc:postgresql://"+"172.19.0.3"+":"+"5432"+"/"+"loga";
    dbUser_tDBOutput_4 = "loga";
 
	final String decryptedPassword_tDBOutput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:9uKZ33EqhDHCD2yZ9AcDlH/a6I1OPwAlwpaVkqjs8KQLTsc6");

    String dbPwd_tDBOutput_4 = decryptedPassword_tDBOutput_4;

    conn_tDBOutput_4 = java.sql.DriverManager.getConnection(url_tDBOutput_4,dbUser_tDBOutput_4,dbPwd_tDBOutput_4);
	
	resourceMap.put("conn_tDBOutput_4", conn_tDBOutput_4);
        conn_tDBOutput_4.setAutoCommit(false);
        int commitEvery_tDBOutput_4 = 10000;
        int commitCounter_tDBOutput_4 = 0;



int count_tDBOutput_4=0;
                                java.sql.DatabaseMetaData dbMetaData_tDBOutput_4 = conn_tDBOutput_4.getMetaData();
                                boolean whetherExist_tDBOutput_4 = false;
                                try (java.sql.ResultSet rsTable_tDBOutput_4 = dbMetaData_tDBOutput_4.getTables(null, null, null, new String[]{"TABLE"})) {
                                    String defaultSchema_tDBOutput_4 = "public";
                                    if(dbschema_tDBOutput_4 == null || dbschema_tDBOutput_4.trim().length() == 0) {
                                        try(java.sql.Statement stmtSchema_tDBOutput_4 = conn_tDBOutput_4.createStatement();
                                            java.sql.ResultSet rsSchema_tDBOutput_4 = stmtSchema_tDBOutput_4.executeQuery("select current_schema() ")) {
                                            while(rsSchema_tDBOutput_4.next()){
                                                defaultSchema_tDBOutput_4 = rsSchema_tDBOutput_4.getString("current_schema");
                                            }
                                        }
                                    }
                                    while(rsTable_tDBOutput_4.next()) {
                                        String table_tDBOutput_4 = rsTable_tDBOutput_4.getString("TABLE_NAME");
                                        String schema_tDBOutput_4 = rsTable_tDBOutput_4.getString("TABLE_SCHEM");
                                        if(table_tDBOutput_4.equals(("fact_tasks"))
                                            && (schema_tDBOutput_4.equals(dbschema_tDBOutput_4) || ((dbschema_tDBOutput_4 ==null || dbschema_tDBOutput_4.trim().length() ==0) && defaultSchema_tDBOutput_4.equals(schema_tDBOutput_4)))) {
                                            whetherExist_tDBOutput_4 = true;
                                            break;
                                        }
                                    }
                                }
                                if(!whetherExist_tDBOutput_4) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_4 = conn_tDBOutput_4.createStatement()) {
                                        stmtCreate_tDBOutput_4.execute("CREATE TABLE \"" + tableName_tDBOutput_4 + "\"(\"pk_task\" INT4 ,\"period\" TIMESTAMP ,\"description\" VARCHAR ,\"dossier\" VARCHAR ,\"is_approved\" BOOL ,\"mileage\" INT4 ,\"reference\" VARCHAR ,\"task\" VARCHAR ,\"duration\" INT4 ,\"cost\" INT4 ,primary key(\"pk_task\"))");
                                    }
                                }
	    java.sql.PreparedStatement pstmt_tDBOutput_4 = conn_tDBOutput_4.prepareStatement("SELECT COUNT(1) FROM \"" + tableName_tDBOutput_4 + "\" WHERE \"pk_task\" = ?");
	    resourceMap.put("pstmt_tDBOutput_4", pstmt_tDBOutput_4);
	    String insert_tDBOutput_4 = "INSERT INTO \"" + tableName_tDBOutput_4 + "\" (\"pk_task\",\"period\",\"description\",\"dossier\",\"is_approved\",\"mileage\",\"reference\",\"task\",\"duration\",\"cost\") VALUES (?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmtInsert_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(insert_tDBOutput_4);
	    resourceMap.put("pstmtInsert_tDBOutput_4", pstmtInsert_tDBOutput_4);
	    String update_tDBOutput_4 = "UPDATE \"" + tableName_tDBOutput_4 + "\" SET \"period\" = ?,\"description\" = ?,\"dossier\" = ?,\"is_approved\" = ?,\"mileage\" = ?,\"reference\" = ?,\"task\" = ?,\"duration\" = ?,\"cost\" = ? WHERE \"pk_task\" = ?";
	    java.sql.PreparedStatement pstmtUpdate_tDBOutput_4 = conn_tDBOutput_4.prepareStatement(update_tDBOutput_4);
	    resourceMap.put("pstmtUpdate_tDBOutput_4", pstmtUpdate_tDBOutput_4);
	    

 



/**
 * [tDBOutput_4 begin ] stop
 */



	
	/**
	 * [tMap_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_4", false);
		start_Hash.put("tMap_4", System.currentTimeMillis());
		
	
	currentComponent="tMap_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_4 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_taskStruct> tHash_Lookup_join_task = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_taskStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_taskStruct>) 
					globalMap.get( "tHash_Lookup_join_task" ))
					;					
					
	

join_taskStruct join_taskHashKey = new join_taskStruct();
join_taskStruct join_taskDefault = new join_taskStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_4__Struct  {
}
Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
copyOfload_repairStruct copyOfload_repair_tmp = new copyOfload_repairStruct();
// ###############################

        
        



        









 



/**
 * [tMap_4 begin ] stop
 */



	
	/**
	 * [tDBInput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_8", false);
		start_Hash.put("tDBInput_8", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_8";

	
		int tos_count_tDBInput_8 = 0;
		
	
    
	
		    int nb_line_tDBInput_8 = 0;
		    java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_8 = java.lang.Class.forName(driverClass_tDBInput_8);
				String dbUser_tDBInput_8 = "loga";
				
				 
	final String decryptedPassword_tDBInput_8 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:7wOFI5xffGtXJ34i39pU/JtkecTN7NK88YtnanLb7DLhRR2O");
				
				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;
				
				String url_tDBInput_8 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8,dbUser_tDBInput_8,dbPwd_tDBInput_8);
		        
				conn_tDBInput_8.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

		    String dbquery_tDBInput_8 = "select \nid,\ncreated_at,\ndescription,\ndossier,\nis_approved,\nmileage,\nreference\nfrom repair";
		    

            	globalMap.put("tDBInput_8_QUERY",dbquery_tDBInput_8);
		    java.sql.ResultSet rs_tDBInput_8 = null;

		    try {
		    	rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
		    	int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

		    String tmpContent_tDBInput_8 = null;
		    
		    
		    while (rs_tDBInput_8.next()) {
		        nb_line_tDBInput_8++;
		        
							if(colQtyInRs_tDBInput_8 < 1) {
								row1.id = null;
							} else {
		                          
            row1.id = rs_tDBInput_8.getLong(1);
            if(rs_tDBInput_8.wasNull()){
                    row1.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 2) {
								row1.created_at = null;
							} else {
										
			row1.created_at = routines.system.JDBCUtil.getDate(rs_tDBInput_8, 2);
		                    }
							if(colQtyInRs_tDBInput_8 < 3) {
								row1.description = null;
							} else {
	                         		
        	row1.description = routines.system.JDBCUtil.getString(rs_tDBInput_8, 3, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 4) {
								row1.dossier = null;
							} else {
	                         		
        	row1.dossier = routines.system.JDBCUtil.getString(rs_tDBInput_8, 4, false);
		                    }
							if(colQtyInRs_tDBInput_8 < 5) {
								row1.is_approved = null;
							} else {
	                         		
            row1.is_approved = rs_tDBInput_8.getBoolean(5);
            if(rs_tDBInput_8.wasNull()){
                    row1.is_approved = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 6) {
								row1.mileage = null;
							} else {
		                          
            row1.mileage = rs_tDBInput_8.getInt(6);
            if(rs_tDBInput_8.wasNull()){
                    row1.mileage = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 7) {
								row1.reference = null;
							} else {
	                         		
        	row1.reference = routines.system.JDBCUtil.getString(rs_tDBInput_8, 7, false);
		                    }
					


 



/**
 * [tDBInput_8 begin ] stop
 */
	
	/**
	 * [tDBInput_8 main ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 


	tos_count_tDBInput_8++;

/**
 * [tDBInput_8 main ] stop
 */
	
	/**
	 * [tDBInput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_begin ] stop
 */

	
	/**
	 * [tMap_4 main ] start
	 */

	

	
	
	currentComponent="tMap_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_4 = false;
		  boolean mainRowRejected_tMap_4 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "join_task" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopjoin_task = false;
       		  	    	
       		  	    	
 							join_taskStruct join_taskObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_4) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_4 = false;
								
                        		    		    join_taskHashKey.repair = row1.id;
                        		    		

								
		                        	join_taskHashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_join_task.lookup( join_taskHashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_join_task.hasNext()) { // G_TM_M_090

  								
		  				
	  								
						
									
	
		  								forceLoopjoin_task = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLoopjoin_task = true;
			           		  	} // G 21
                    		  	
                    		

							join_taskStruct join_task = null;
                    		  	 
							

								while ((tHash_Lookup_join_task != null && tHash_Lookup_join_task.hasNext()) || forceLoopjoin_task) { // G_TM_M_043

								
									 // CALL close loop of lookup 'join_task'
									
                    		  	 
							   
                    		  	 
	       		  	    	join_taskStruct fromLookup_join_task = null;
							join_task = join_taskDefault;
										 
							
								
								if(!forceLoopjoin_task) { // G 46
								
							
								 
							
								
								fromLookup_join_task = tHash_Lookup_join_task.next();

							

							if(fromLookup_join_task != null) {
								join_task = fromLookup_join_task;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLoopjoin_task = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
        // ###############################
        // # Output tables

copyOfload_repair = null;


// # Output table : 'copyOfload_repair'
copyOfload_repair_tmp.pk_task = Numeric.sequence("s1",1,1) ;
copyOfload_repair_tmp.period = row1.created_at ;
copyOfload_repair_tmp.description = row1.description ;
copyOfload_repair_tmp.dossier = row1.dossier ;
copyOfload_repair_tmp.is_approved = row1.is_approved ;
copyOfload_repair_tmp.mileage = row1.mileage ;
copyOfload_repair_tmp.reference = row1.reference ;
copyOfload_repair_tmp.task = join_task.description ;
copyOfload_repair_tmp.duration = join_task.duration ;
copyOfload_repair_tmp.cost = join_task.cost ;
copyOfload_repair = copyOfload_repair_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_4 = false;










 


	tos_count_tMap_4++;

/**
 * [tMap_4 main ] stop
 */
	
	/**
	 * [tMap_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_begin ] stop
 */
// Start of branch "copyOfload_repair"
if(copyOfload_repair != null) { 



	
	/**
	 * [tDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"copyOfload_repair"
						
						);
					}
					



        whetherReject_tDBOutput_4 = false;
                    if(copyOfload_repair.pk_task == null) {
pstmt_tDBOutput_4.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_4.setInt(1, copyOfload_repair.pk_task);
}

            int checkCount_tDBOutput_4 = -1;
            try (java.sql.ResultSet rs_tDBOutput_4 = pstmt_tDBOutput_4.executeQuery()) {
                while(rs_tDBOutput_4.next()) {
                    checkCount_tDBOutput_4 = rs_tDBOutput_4.getInt(1);
                }
            }
            if(checkCount_tDBOutput_4 > 0) {
                        if(copyOfload_repair.period != null) {
pstmtUpdate_tDBOutput_4.setTimestamp(1, new java.sql.Timestamp(copyOfload_repair.period.getTime()));
} else {
pstmtUpdate_tDBOutput_4.setNull(1, java.sql.Types.TIMESTAMP);
}

                        if(copyOfload_repair.description == null) {
pstmtUpdate_tDBOutput_4.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(2, copyOfload_repair.description);
}

                        if(copyOfload_repair.dossier == null) {
pstmtUpdate_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(3, copyOfload_repair.dossier);
}

                        if(copyOfload_repair.is_approved == null) {
pstmtUpdate_tDBOutput_4.setNull(4, java.sql.Types.BOOLEAN);
} else {pstmtUpdate_tDBOutput_4.setBoolean(4, copyOfload_repair.is_approved);
}

                        if(copyOfload_repair.mileage == null) {
pstmtUpdate_tDBOutput_4.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_4.setInt(5, copyOfload_repair.mileage);
}

                        if(copyOfload_repair.reference == null) {
pstmtUpdate_tDBOutput_4.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(6, copyOfload_repair.reference);
}

                        if(copyOfload_repair.task == null) {
pstmtUpdate_tDBOutput_4.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_4.setString(7, copyOfload_repair.task);
}

                        if(copyOfload_repair.duration == null) {
pstmtUpdate_tDBOutput_4.setNull(8, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_4.setInt(8, copyOfload_repair.duration);
}

                        if(copyOfload_repair.cost == null) {
pstmtUpdate_tDBOutput_4.setNull(9, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_4.setInt(9, copyOfload_repair.cost);
}

                        if(copyOfload_repair.pk_task == null) {
pstmtUpdate_tDBOutput_4.setNull(10 + count_tDBOutput_4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_4.setInt(10 + count_tDBOutput_4, copyOfload_repair.pk_task);
}

                try {
					
                    int processedCount_tDBOutput_4 = pstmtUpdate_tDBOutput_4.executeUpdate();
                    updatedCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    rowsToCommitCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    nb_line_tDBOutput_4++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_4 = true;
                        nb_line_tDBOutput_4++;
                            System.err.print(e.getMessage());
                }
            } else {
                        if(copyOfload_repair.pk_task == null) {
pstmtInsert_tDBOutput_4.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_4.setInt(1, copyOfload_repair.pk_task);
}

                        if(copyOfload_repair.period != null) {
pstmtInsert_tDBOutput_4.setTimestamp(2, new java.sql.Timestamp(copyOfload_repair.period.getTime()));
} else {
pstmtInsert_tDBOutput_4.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(copyOfload_repair.description == null) {
pstmtInsert_tDBOutput_4.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(3, copyOfload_repair.description);
}

                        if(copyOfload_repair.dossier == null) {
pstmtInsert_tDBOutput_4.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(4, copyOfload_repair.dossier);
}

                        if(copyOfload_repair.is_approved == null) {
pstmtInsert_tDBOutput_4.setNull(5, java.sql.Types.BOOLEAN);
} else {pstmtInsert_tDBOutput_4.setBoolean(5, copyOfload_repair.is_approved);
}

                        if(copyOfload_repair.mileage == null) {
pstmtInsert_tDBOutput_4.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_4.setInt(6, copyOfload_repair.mileage);
}

                        if(copyOfload_repair.reference == null) {
pstmtInsert_tDBOutput_4.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(7, copyOfload_repair.reference);
}

                        if(copyOfload_repair.task == null) {
pstmtInsert_tDBOutput_4.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_4.setString(8, copyOfload_repair.task);
}

                        if(copyOfload_repair.duration == null) {
pstmtInsert_tDBOutput_4.setNull(9, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_4.setInt(9, copyOfload_repair.duration);
}

                        if(copyOfload_repair.cost == null) {
pstmtInsert_tDBOutput_4.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_4.setInt(10, copyOfload_repair.cost);
}

                try {
					
                    int processedCount_tDBOutput_4 = pstmtInsert_tDBOutput_4.executeUpdate();
                    insertedCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    rowsToCommitCount_tDBOutput_4 += processedCount_tDBOutput_4;
                    nb_line_tDBOutput_4++;
					
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_4_ERROR_MESSAGE",e.getMessage());
					
                    whetherReject_tDBOutput_4 = true;
                        nb_line_tDBOutput_4++;
                            System.err.print(e.getMessage());
                }
            }
    		    commitCounter_tDBOutput_4++;
                if(commitEvery_tDBOutput_4 <= commitCounter_tDBOutput_4) {
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                    	
                    }
                    conn_tDBOutput_4.commit();
                    if(rowsToCommitCount_tDBOutput_4 != 0){
                    	
                    	rowsToCommitCount_tDBOutput_4 = 0;
                    }
                    commitCounter_tDBOutput_4=0;
                }

 


	tos_count_tDBOutput_4++;

/**
 * [tDBOutput_4 main ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	

 



/**
 * [tDBOutput_4 process_data_end ] stop
 */

} // End of branch "copyOfload_repair"



	
		} // close loop of lookup 'join_task' // G_TM_M_043
	
	
	/**
	 * [tMap_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_8 end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

	}
}finally{
	if (rs_tDBInput_8 != null) {
		rs_tDBInput_8.close();
	}
	if (stmt_tDBInput_8 != null) {
		stmt_tDBInput_8.close();
	}
	if(conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {
		
			conn_tDBInput_8.commit();
			
		
			conn_tDBInput_8.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_8_NB_LINE",nb_line_tDBInput_8);
 

ok_Hash.put("tDBInput_8", true);
end_Hash.put("tDBInput_8", System.currentTimeMillis());




/**
 * [tDBInput_8 end ] stop
 */

	
	/**
	 * [tMap_4 end ] start
	 */

	

	
	
	currentComponent="tMap_4";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_join_task != null) {
						tHash_Lookup_join_task.endGet();
					}
					globalMap.remove( "tHash_Lookup_join_task" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_4", true);
end_Hash.put("tMap_4", System.currentTimeMillis());




/**
 * [tMap_4 end ] stop
 */

	
	/**
	 * [tDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



        if(pstmtUpdate_tDBOutput_4 != null){
            pstmtUpdate_tDBOutput_4.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_4");
        }
        if(pstmtInsert_tDBOutput_4 != null){
            pstmtInsert_tDBOutput_4.close();
            resourceMap.remove("pstmtInsert_tDBOutput_4");
        }
        if(pstmt_tDBOutput_4 != null) {
            pstmt_tDBOutput_4.close();
            resourceMap.remove("pstmt_tDBOutput_4");
        }
    resourceMap.put("statementClosed_tDBOutput_4", true);
			if(rowsToCommitCount_tDBOutput_4 != 0){
				
			}
			conn_tDBOutput_4.commit();
			if(rowsToCommitCount_tDBOutput_4 != 0){
				
				rowsToCommitCount_tDBOutput_4 = 0;
			}
			commitCounter_tDBOutput_4 = 0;
		
    	conn_tDBOutput_4 .close();
    	
    	resourceMap.put("finish_tDBOutput_4", true);
    	

	nb_line_deleted_tDBOutput_4=nb_line_deleted_tDBOutput_4+ deletedCount_tDBOutput_4;
	nb_line_update_tDBOutput_4=nb_line_update_tDBOutput_4 + updatedCount_tDBOutput_4;
	nb_line_inserted_tDBOutput_4=nb_line_inserted_tDBOutput_4 + insertedCount_tDBOutput_4;
	nb_line_rejected_tDBOutput_4=nb_line_rejected_tDBOutput_4 + rejectedCount_tDBOutput_4;
	
        globalMap.put("tDBOutput_4_NB_LINE",nb_line_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_UPDATED",nb_line_update_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_DELETED",nb_line_deleted_tDBOutput_4);
        globalMap.put("tDBOutput_4_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_4);
    

	


				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"copyOfload_repair");
			  	}
			  	
 

ok_Hash.put("tDBOutput_4", true);
end_Hash.put("tDBOutput_4", System.currentTimeMillis());




/**
 * [tDBOutput_4 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_4"
					     			globalMap.remove("tHash_Lookup_join_task"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_8 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 finally ] stop
 */

	
	/**
	 * [tMap_4 finally ] start
	 */

	

	
	
	currentComponent="tMap_4";

	

 



/**
 * [tMap_4 finally ] stop
 */

	
	/**
	 * [tDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_4";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_4") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_4 = null;
                if ((pstmtUpdateToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_4")) != null) {
                    pstmtUpdateToClose_tDBOutput_4.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_4 = null;
                if ((pstmtInsertToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_4")) != null) {
                    pstmtInsertToClose_tDBOutput_4.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_4 = null;
                if ((pstmtToClose_tDBOutput_4 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_4")) != null) {
                    pstmtToClose_tDBOutput_4.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_4") == null){
            java.sql.Connection ctn_tDBOutput_4 = null;
            if((ctn_tDBOutput_4 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_4")) != null){
                try {
                    ctn_tDBOutput_4.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_4) {
                    String errorMessage_tDBOutput_4 = "failed to close the connection in tDBOutput_4 :" + sqlEx_tDBOutput_4.getMessage();
                    System.err.println(errorMessage_tDBOutput_4);
                }
            }
        }
    }
 



/**
 * [tDBOutput_4 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}
	


public static class join_taskStruct implements routines.system.IPersistableComparableLookupRow<join_taskStruct> {
    final static byte[] commonByteArrayLock_TFE_MASTER_tfe_master = new byte[0];
    static byte[] commonByteArray_TFE_MASTER_tfe_master = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Long id;

				public Long getId () {
					return this.id;
				}
				
			    public String description;

				public String getDescription () {
					return this.description;
				}
				
			    public Integer duration;

				public Integer getDuration () {
					return this.duration;
				}
				
			    public Integer cost;

				public Integer getCost () {
					return this.cost;
				}
				
			    public Long repair;

				public Long getRepair () {
					return this.repair;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.repair == null) ? 0 : this.repair.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final join_taskStruct other = (join_taskStruct) obj;
		
						if (this.repair == null) {
							if (other.repair != null)
								return false;
						
						} else if (!this.repair.equals(other.repair))
						
							return false;
					

		return true;
    }

	public void copyDataTo(join_taskStruct other) {

		other.id = this.id;
	            other.description = this.description;
	            other.duration = this.duration;
	            other.cost = this.cost;
	            other.repair = this.repair;
	            
	}

	public void copyKeysDataTo(join_taskStruct other) {

		other.repair = this.repair;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.repair = null;
           				} else {
           			    	this.repair = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TFE_MASTER_tfe_master) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.repair = null;
           				} else {
           			    	this.repair = dis.readLong();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// Long
				
						if(this.repair == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.repair);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Long
				
						if(this.repair == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.repair);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = dis.readLong();
           				}
					
						this.description = readString(dis,ois);
					
						this.duration = readInteger(dis,ois);
					
						this.cost = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.id = null;
           				} else {
           			    	this.id = objectIn.readLong();
           				}
					
						this.description = readString(dis,objectIn);
					
						this.duration = readInteger(dis,objectIn);
					
						this.cost = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						if(this.id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.id);
		            	}
					
						writeString(this.description, dos, oos);
					
					writeInteger(this.duration, dos, oos);
					
					writeInteger(this.cost, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						if(this.id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.id);
		            	}
					
						writeString(this.description, dos, objectOut);
					
					writeInteger(this.duration, dos, objectOut);
					
					writeInteger(this.cost, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
		sb.append(",description="+description);
		sb.append(",duration="+String.valueOf(duration));
		sb.append(",cost="+String.valueOf(cost));
		sb.append(",repair="+String.valueOf(repair));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(join_taskStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.repair, other.repair);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_9_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		join_taskStruct join_task = new join_taskStruct();




	
	/**
	 * [tAdvancedHash_join_task begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_join_task", false);
		start_Hash.put("tAdvancedHash_join_task", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_join_task";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"join_task");
					}
				
		int tos_count_tAdvancedHash_join_task = 0;
		

			   		// connection name:join_task
			   		// source node:tDBInput_9 - inputs:(after_tDBInput_8) outputs:(join_task,join_task) | target node:tAdvancedHash_join_task - inputs:(join_task) outputs:()
			   		// linked node: tMap_4 - inputs:(row1,join_task) outputs:(copyOfload_repair)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_join_task = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<join_taskStruct> tHash_Lookup_join_task =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<join_taskStruct>getLookup(matchingModeEnum_join_task);
	   						   
		   	   	   globalMap.put("tHash_Lookup_join_task", tHash_Lookup_join_task);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_join_task begin ] stop
 */



	
	/**
	 * [tDBInput_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_9", false);
		start_Hash.put("tDBInput_9", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_9";

	
		int tos_count_tDBInput_9 = 0;
		
	
    
	
		    int nb_line_tDBInput_9 = 0;
		    java.sql.Connection conn_tDBInput_9 = null;
				String driverClass_tDBInput_9 = "org.postgresql.Driver";
			    java.lang.Class jdbcclazz_tDBInput_9 = java.lang.Class.forName(driverClass_tDBInput_9);
				String dbUser_tDBInput_9 = "loga";
				
				 
	final String decryptedPassword_tDBInput_9 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:BIMlwRvPecxT960kxBVpwEz6NZqdltekXtJS1/+tcCDjFsk/");
				
				String dbPwd_tDBInput_9 = decryptedPassword_tDBInput_9;
				
				String url_tDBInput_9 = "jdbc:postgresql://" + "172.19.0.5" + ":" + "5432" + "/" + "loga";
				
				conn_tDBInput_9 = java.sql.DriverManager.getConnection(url_tDBInput_9,dbUser_tDBInput_9,dbPwd_tDBInput_9);
		        
				conn_tDBInput_9.setAutoCommit(false);
			
		    
			java.sql.Statement stmt_tDBInput_9 = conn_tDBInput_9.createStatement();

		    String dbquery_tDBInput_9 = "select id,description,duration,cost,repair from task";
		    

            	globalMap.put("tDBInput_9_QUERY",dbquery_tDBInput_9);
		    java.sql.ResultSet rs_tDBInput_9 = null;

		    try {
		    	rs_tDBInput_9 = stmt_tDBInput_9.executeQuery(dbquery_tDBInput_9);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_9 = rs_tDBInput_9.getMetaData();
		    	int colQtyInRs_tDBInput_9 = rsmd_tDBInput_9.getColumnCount();

		    String tmpContent_tDBInput_9 = null;
		    
		    
		    while (rs_tDBInput_9.next()) {
		        nb_line_tDBInput_9++;
		        
							if(colQtyInRs_tDBInput_9 < 1) {
								join_task.id = null;
							} else {
		                          
            join_task.id = rs_tDBInput_9.getLong(1);
            if(rs_tDBInput_9.wasNull()){
                    join_task.id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 2) {
								join_task.description = null;
							} else {
	                         		
        	join_task.description = routines.system.JDBCUtil.getString(rs_tDBInput_9, 2, false);
		                    }
							if(colQtyInRs_tDBInput_9 < 3) {
								join_task.duration = null;
							} else {
		                          
            join_task.duration = rs_tDBInput_9.getInt(3);
            if(rs_tDBInput_9.wasNull()){
                    join_task.duration = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 4) {
								join_task.cost = null;
							} else {
		                          
            join_task.cost = rs_tDBInput_9.getInt(4);
            if(rs_tDBInput_9.wasNull()){
                    join_task.cost = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 5) {
								join_task.repair = null;
							} else {
		                          
            join_task.repair = rs_tDBInput_9.getLong(5);
            if(rs_tDBInput_9.wasNull()){
                    join_task.repair = null;
            }
		                    }
					


 



/**
 * [tDBInput_9 begin ] stop
 */
	
	/**
	 * [tDBInput_9 main ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 


	tos_count_tDBInput_9++;

/**
 * [tDBInput_9 main ] stop
 */
	
	/**
	 * [tDBInput_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_join_task main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_task";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"join_task"
						
						);
					}
					


			   
			   

					join_taskStruct join_task_HashRow = new join_taskStruct();
		   	   	   
				
				join_task_HashRow.id = join_task.id;
				
				join_task_HashRow.description = join_task.description;
				
				join_task_HashRow.duration = join_task.duration;
				
				join_task_HashRow.cost = join_task.cost;
				
				join_task_HashRow.repair = join_task.repair;
				
			tHash_Lookup_join_task.put(join_task_HashRow);
			
            




 


	tos_count_tAdvancedHash_join_task++;

/**
 * [tAdvancedHash_join_task main ] stop
 */
	
	/**
	 * [tAdvancedHash_join_task process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_task";

	

 



/**
 * [tAdvancedHash_join_task process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_join_task process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_task";

	

 



/**
 * [tAdvancedHash_join_task process_data_end ] stop
 */



	
	/**
	 * [tDBInput_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_9 end ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

	}
}finally{
	if (rs_tDBInput_9 != null) {
		rs_tDBInput_9.close();
	}
	if (stmt_tDBInput_9 != null) {
		stmt_tDBInput_9.close();
	}
	if(conn_tDBInput_9 != null && !conn_tDBInput_9.isClosed()) {
		
			conn_tDBInput_9.commit();
			
		
			conn_tDBInput_9.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}
	
}
globalMap.put("tDBInput_9_NB_LINE",nb_line_tDBInput_9);
 

ok_Hash.put("tDBInput_9", true);
end_Hash.put("tDBInput_9", System.currentTimeMillis());




/**
 * [tDBInput_9 end ] stop
 */

	
	/**
	 * [tAdvancedHash_join_task end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_task";

	

tHash_Lookup_join_task.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"join_task");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_join_task", true);
end_Hash.put("tAdvancedHash_join_task", System.currentTimeMillis());




/**
 * [tAdvancedHash_join_task end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_9 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_join_task finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_join_task";

	

 



/**
 * [tAdvancedHash_join_task finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_9_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final tfe_master tfe_masterClass = new tfe_master();

        int exitCode = tfe_masterClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = tfe_master.class.getClassLoader().getResourceAsStream("tfe_master/tfe_master_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = tfe_master.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}
try {
errorCode = null;tDBInput_4Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_4) {
globalMap.put("tDBInput_4_SUBPROCESS_STATE", -1);

e_tDBInput_4.printStackTrace();

}
try {
errorCode = null;tDBInput_6Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_6) {
globalMap.put("tDBInput_6_SUBPROCESS_STATE", -1);

e_tDBInput_6.printStackTrace();

}
try {
errorCode = null;tDBInput_8Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_8) {
globalMap.put("tDBInput_8_SUBPROCESS_STATE", -1);

e_tDBInput_8.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : tfe_master");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     380677 characters generated by Talend Open Studio for Data Integration 
 *     on the 30 juillet 2023 à 20:20:56 WAT
 ************************************************************************************************/