package util;
import model.*;
import java.io.*;
import exceptions.*;


/**
 * When given a input txt file, this class is gong to establish a car 
 * configuration model that contains car model, car color, car transmission
 * selection, car brakers selection, car Air bags selection and Car Power Moonroof selection.
 * <p>
 * Serialization is a very good way to keep data imported in the last process intact.
 * In order to keep our data from corruption, serializable interface is implemented here.
 * After serialization, a accordingly data file is created and keep the data.
 * If we want to retrieve our data, deserializarion is needed in this process.
 * 
 * @author--Yi
 * @version--1.0
 * @since--Sep/14/2015
 */

//This class is to read configurations from txt file and to build auto objects

public class Util implements Serializable{
	
	//Declare a serial version UID
	static final long serialVersionUID = 1;
	
	
	/**
	 * This method is an instance method and is to build auto objects.
	 * <p>
	 * Given a filename path, we can load these data into our target object.
	 * In order to make our code more flexible, data file must obey some kind 
	 * of format.
	 * <p>
	 * In this case, a car configuration model is established, so different option sets
	 * and different options in one option set should be stored properly.
	 * 
	 * @param filename true
	 * @return Automotive 
	 * @throws IOException true
	 * @since 1.0
	 */
	public Automotbile readFile(String filename) throws IOException,BlankFile,
	                                                    InvalidFileType,
	                                                    OptionNotFound,
	                                                    PriceNotFound{
		
		//Create a read file stream and a processing flow
		FileReader read = null;
		BufferedReader bufferRead = null;
		
		//Create a new automotive model
		Automotbile al = null;
		
		
		//If file name is not a text file, throw InvalidFileType exception.
		String type = filename.substring(filename.length()-4);
		
		if(filename.length()<=4) {
			throw new InvalidFileType();
		}
		if(!type.equals(".txt")) {
			throw new InvalidFileType();
		}
		
		try{
			//Initialize a input file flow of file
			read = new FileReader(filename);
			
			//Initialize a process flow based on file flow
			bufferRead = new BufferedReader(read);
	
			//Read each line of txt file and configure each optionset and option
			//Configure model name, optionset size and base price
			String buffer;
			
			//Read the first line of txt file
			buffer = bufferRead.readLine();
			
			//If the file is a blank file, throw blank file exception.
			if(buffer == null) {
				throw new BlankFile();
			}
			
			//Split the first line string
			String[] str = buffer.split(",");
			
			//Use constructor with arguments to configure a car model
			al = new Automotbile(str[0],Integer.parseInt(str[1]),Float.parseFloat(str[2]));
	
			//Continue to read file to set up other configurations
			for(int i=0;i<Integer.parseInt(str[1]);i++){
				buffer = bufferRead.readLine();
				String[] opsetStr = buffer.split(",");
				al.setOptionsetValue(i,opsetStr[0],Integer.parseInt(opsetStr[1]));
				for(int j=0;j<Integer.parseInt(opsetStr[1]);j++){
					String[] optStr = (bufferRead.readLine()).split(",");
					
					//If there is onlu one string in this option part, it must be losing something.
					//Option price or option name.
					if(optStr.length == 1) {
						//First we check what is lost. Using isPrice we can know the only data is 
						//price or name.
						char[] check = optStr[0].toCharArray();
						boolean val = isPrice(check);
						
						//If the only data is price, the option name is missing. We should input its option name.
						if(val) {
							//Throw an option name is missing.
							OptionNotFound error = new OptionNotFound();
							error.print();
							error.log(error.getErrno());
							System.out.println("You lost the option name in option set " + opsetStr[0]);
							String name;
							name = error.fix(error.getErrno());
							al.setOptionValue(i,name,Float.parseFloat(optStr[0]),j);
						}
						//If the only data is name, then option price is missing, we should input its price.
						else {
						//Throw a price not found exception.
					    PriceNotFound error = new PriceNotFound();
					    error.print();
					    error.log(error.getErrno());
						System.out.println("You lost the price of option " + optStr[0] + 
								           " in option set " + opsetStr[0]);
						String price;
						price = error.fix(error.getErrno());
						al.setOptionValue(i,optStr[0],Float.parseFloat(price),j);
						}
					}
					//If there is more than one data, it means no option price and no option name is missing.
					else {
						al.setOptionValue(i,optStr[0],Float.parseFloat(optStr[1]),j);
					}
				}
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try{
				bufferRead.close();
			}catch(IOException closeError){
				closeError.printStackTrace();
			}
		}
		
		return al;
	}
	
	/**
	 * Serialize the input data.
	 * <p>
	 * In order to keep our input data from changes and corruption,
	 * serialization can be very useful.In this way, a complete data
	 * can be stored safely in case of later retrieve.
	 * 
	 * @param auto An automotive instance variable
	 * @since 1.0
	 */
	public void serializeAuto(Automotbile auto){
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(
					                 new FileOutputStream("ZTW.ser"));
			out.writeObject(auto);
			System.out.println("Serialization ZTW.ser");
			System.out.println("Serializarion is done!");
			System.out.println("--------------------------------------------");
			
		}catch(Exception e){
			System.out.println("Error--->" + e);
			System.exit(1);
		}finally {
			try{
				out.close();
			}catch(Exception closeError){
				System.out.print("Error--->" + closeError);
				System.exit(1);
			}
		}
	}
	
	/**
	 * Deserialize the input data
	 * <p>
	 * In order to retrieve the data we have stored before,
	 * deserialization can be very helpful. In this way, a complete
	 * data can be retrieved without any changes and corruptions. 
	 * @since 1.0 
	 */
	public void deserializeAuto(){
		ObjectInputStream in = null; 
		
		try{
			in = new ObjectInputStream(new FileInputStream("ZTW.ser"));
			Automotbile newAuto = (Automotbile) in.readObject();
			System.out.println("Deserialization ZTW.ser");
			System.out.println("Deserializarion is done!");
			System.out.println("After serialization, the data is kept intact.");
			newAuto.printBasicInfo();
			newAuto.printAdditionalInfo();
		}catch(Exception e){
			System.out.println("Error--->" + e);
		}finally {
			try{
				in.close();
			}catch(Exception closeError){
				System.out.println("Error--->" + closeError);
			}
		}
	}
	
	public boolean isPrice(char[] src) {
		for(int i=0;i<src.length;i++) {
			if(!Character.isDigit(src[i])) {
				return false;
			}
		}
		return true;
	}
}
