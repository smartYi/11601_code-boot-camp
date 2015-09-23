package model;

import java.io.Serializable;
import model.Optionset.Option;

/**
 * Automotive class is a the core part of the car configuration model.
 * In this class, a lot of functions are included. These are the following:
 * $Constructor
 *    1) public Automotive(){}
 *    2) public Automotive(String name, int size, float basePrice){}
 * $Getter
 *    1) public String getName(){}
 *    2) public float getBasePrice(){}
 *    3) public Optionset getOptionsSet(int index){}
 *    4) public Optionset getOptionsSet(String opsetName){}
 * $Find
 *    1) public Optionset findOptionset(String name){}
 *    2) public Optionset findOptionSet(int opsetIndex){}
 *    3) public Option findOption(int opsetIndex, String name){}
 * $Delete
 *    1) public void deleteOptionset(int index){}
 *    2) public void deleteOptionset(String name){}
 *    3) public void deleteOption(int opsetIndex, String optionName){}
 *    4) public void deleteOption(String opsetName, String optionName){}
 * $Update
 *    1) public void updateOptionset(int opsetIndex, String name,int size){}
 *    2) public void updateOptionset(String name,int size){}
 *    3) public void updateOptionName(int opsetIndex, String oldName, String newName){}
 *    4) public void updateOptionName(int opsetIndex, int optionIndex, String newName){}
 *    5) public void updateOptionPrice(int opsetIndex, String name, float price){}
 *    6) public void updateOptionPrice(int opsetIndex, int optionIndex, float price){}
 * $Print
 *    1) public void printBasicInfo(){}
 *    2) public void printAdditionalInfo() {}
 *    
 * Detailed description is shown in each method documentation.
 * <p>
 * All of these functions establish the car configuration model.
 * <p>
 * Also in order to keep our configuration model intact, serialization can be very helpful.
 * So Serializable interface is implemented here. 
 *    
 * @author--Yi
 * @version--1.0
 * @since--Sep/14/2015
 */

//This class will represent the Model
public class Automotbile implements Serializable{
	
	//Declare a serial version UID
	static final long serialVersionUID = 1;
		
	//Each model should have a name
	private String name;
	
	//Each model should have a set of options
	private Optionset opset[];
	
	//Each model should have a base price
	private float basePrice;
	
	//Constructor: Two constructors
	/**
	 * Default constructor.
	 */
	public Automotbile(){}
	
	/**
	 * Constructor with arguments.
	 * @param name true
	 * @param size true
	 * @param basePrice true
	 */
	public Automotbile(String name, int size, float basePrice){
		opset = new Optionset[size];
		this.name = name;
		this.basePrice = basePrice;
		
		//Create an object for each element in opset to avoid null pointer
		for(int i=0;i<size;i++){
			opset[i] = new Optionset();
		}
	}

	//Getters
	/**
	 * 1: Get model name.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 2:Get model base price.
	 * @return base price
	 */
	public float getBasePrice() {
		return basePrice;
	}
	
	//3:Get option set 
	/**
	 * 3.1: Get option set by opset index.
	 * @param index true
	 * @return optionset
	 */
	public Optionset getOptionsSet(int index){
		if(index<opset.length && index>=0){
			if(opset[index]!=null){
				return opset[index];
			}
		}
		return null;
	}
	
	/**
	 * 3.2: Get option set by opset name.
	 * @param opsetName true
	 * @return optionset
	 */
	public Optionset getOptionsSet(String opsetName){
		for(int i=0;i<opset.length;i++){
			if(opset[i]!=null && opset[i].getName().equals(opsetName)){
				return opset[i];
			}
		}
		return null;
	}
	
	/**
	 * 4. This method is to get the option price given set name and option name.
	 * @param setIndex
	 * @param optionName
	 * @return
	 */
	public float getOptionPrice(int setIndex, String optionName) {
		if(setIndex>=0 && setIndex < opset.length) {
			if(opset[setIndex]!=null) {
				Option[] temp = opset[setIndex].getOpt();
				for(int i=0;i<temp.length;i++) {
					if(temp[i].getName().equals(optionName)) {
							return temp[i].getPrice();
					}
				}
			}
		}
		return 0;
	}
	
	
	//Setters functions
	/**
	 * 1: Set model name.
	 * @param name true
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 2: Set model base price.
	 * @param basePrice true
	 */
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	//3. Set option set
	/**
	 * 3.1 : Set option set name and size by its optionset index.
	 * @param index true 
	 * @param name true
	 * @param size true
	 */
	public void setOptionsetValue(int index,String name,int size){
		if(index<opset.length && index>=0){
			opset[index] = new Optionset(name,size);
		}
	}
	
	/**
	 * 3.2 : Set option set size by its name.
	 * @param name true
	 * @param size true
	 */
		public void setOptionsetValue(String name,int size){
			for(int i=0;i<opset.length;i++){
				if(opset[i].getName().equals(name)){
					opset[i] = new Optionset(name,size);
				}
			}
		}
	
	/**
	 * 4: Set option name, price with its optionset index and option index.
	 * @param opsetIndex true
	 * @param optionName true
	 * @param price true
	 * @param optionIndex true
	 */
	public void setOptionValue(int opsetIndex, String optionName, 
			                   float price,int optionIndex) {
		if(getOptionsSet(opsetIndex)!=null){
			opset[opsetIndex].setOption(optionIndex, optionName, price);
		}
	}
	
	
	
	
	//Findings functions
	//1: Find option set
	/**
	 * 1.1: Find option set with its name.
	 * @param name true
	 * @return Optionset
	 */
	public Optionset findOptionset(String name){	
		
		//Loop to pick out the option name same to the input
		for(int i=0;i<opset.length;i++){
			if(opset[i]!=null){
				if(opset[i].getName().equals(name)) return opset[i];
			}
		}
		return null;
	}
	
	/**
	 * 1.2: Find option set with its index.
	 * @param opsetIndex true
	 * @return Optionset
	 */
	public Optionset findOptionSet(int opsetIndex){
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
				return opset[opsetIndex];
				}
		}
		return null;
	}
	
	/**
	 * 2: Find option in one optionset.
	 * @param opsetIndex true
	 * @param name true
	 * @return Option
	 */
	public Option findOption(int opsetIndex, String name){

		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
				opset[opsetIndex].getOption(name);
			}
		}
		return null;
	}
	
	
	//Delete functions
	//1: Delete option set
	/**
	 * 1.1: Delete option set with its index.
	 * @param index true
	 */
    public void deleteOptionset(int index) {
		
		if(index<opset.length && index>=0){
			if(opset[index]!=null){
				opset[index] = null;
			}
		}
	}
    
    /**
     * 1.2: Delete optionset with its name.
     * @param name true
     */
    public void deleteOptionset(String name){
    	for(int i=0;i<opset.length;i++){
    		if(opset[i]!=null && opset[i].getName().equals(name)){
    			opset[i] = null;
    		}
    	}
    }
    
    //2: Delete option
    /**
     * 2.1: Delete option with its opset index and its name.
     * @param opsetIndex true
     * @param optionName true
     */
	public void deleteOption(int opsetIndex, String optionName){
		
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
				opset[opsetIndex].deleteOption(optionName);
			}
		}
	}
	
	/**
	 * 2.2: Delete option with its opset name and its name.
	 * @param opsetName true
	 * @param optionName true
	 */
    public void deleteOption(String opsetName, String optionName){
		for(int i=0;i<opset.length;i++){
			if(opset[i]!=null && opset[i].getName().equals(opsetName)){
				opset[i].deleteOption(optionName);
			}
		}
	}
	
	//Update functions
	
    //1: Update option set name and size
    /**
     * 1.1: Update option set with its opset index and update its name and size.
     * @param opsetIndex true
     * @param name true
     * @param size true
     */
	public void updateOptionset(int opsetIndex, String name,int size) {
		if(opsetIndex<opset.length && opsetIndex>=0){
			Optionset result = new Optionset(name,size);
			Option[] tempSrc =  opset[opsetIndex].getOpt();
			Option[] tempDes = result.getOpt();
			for(int i=0;i<size;i++){
				tempDes[i] = tempSrc[i];
			}
			result.setOpt(tempDes);
			opset[opsetIndex] = result;
		}
	}
	
	/**
	 * 1.2: Update optionset size.
	 * @param name true
	 * @param size true
	 */
	public void updateOptionset(String name,int size) {
		for(int i=0;i<opset.length;i++){
			if(opset[i]!=null && opset[i].getName().equals(name)){
				Optionset result = new Optionset(name,size);
				Option[] tempSrc =  opset[i].getOpt();
				Option[] tempDes = result.getOpt();
				for(int j=0;j<size;j++){
					if(j<tempSrc.length){
						tempDes[j] = tempSrc[j];
					}else{
						tempDes[j] = null;
					}
				}
				result.setOpt(tempDes);
				opset[i] = result;
			}
		}
	}
	
	/**
	 * 1.3: Update option set name. 
	 * This method is to update option set name with its old name and its new name.
	 * @param oldName true
	 * @param newName true
	 */
	public void updateOptionSetName(String oldName, String newName) {
		for(int i=0;i<opset.length;i++) {
			if(opset[i]!=null && opset[i].getName().equals(oldName)) {
				opset[i].setName(newName);
			}
		}
		
	}
	
	//2: Update option name
	/**
	 * 2.1: Update option name with its opset index and its old name.
	 * @param opsetIndex true
	 * @param oldName true
	 * @param newName true
	 */
	public void updateOptionName(int opsetIndex, String oldName, String newName) {
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
			opset[opsetIndex].updateOptionName(oldName, newName);
			}
		}
	}
	
	/**
	 * 2.2: Update option name with its opset index and its old name.
	 * @param opsetIndex true
	 * @param optionIndex true
	 * @param newName true
	 */
	public void updateOptionName(int opsetIndex, int optionIndex, String newName) {
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
			opset[opsetIndex].updateOptionName(optionIndex, newName);
			}
		}
	}
	
	
	//3: Update option price
	/**
	 * 3.1: Update option price with its opset index and its name.
	 * @param opsetIndex true
	 * @param name true
	 * @param price true
	 */
	public void updateOptionPrice(int opsetIndex, String name, float price) {
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
			opset[opsetIndex].updateOptionPrice(name, price);
			}
		}
	}
	
	/**
	 * 3.2: Update option price with its opset index and its option index.
	 * @param opsetIndex true
	 * @param optionIndex true
	 * @param price true
	 */
	public void updateOptionPrice(int opsetIndex, int optionIndex, float price) {
		if(opsetIndex<opset.length && opsetIndex>=0){
			if(opset[opsetIndex]!=null){
			opset[opsetIndex].updateOptionPrice(optionIndex, price);
			}
		}
	}
	
	/**
	 * This method is to update an option price with in its option set name and its option name.
	 * @param optionSetName
	 * @param optionName
	 * @param price
	 */
	public void updateOptionPrice(String optionSetName, String optionName, float price) {
		for(int i=0;i<opset.length;i++) {
			if(opset[i]!=null && opset[i].getName().equals(optionSetName)) {
				for(int j=0;j<opset[i].getOpt().length;j++) {
					if(opset[i].getOpt()[j]!=null && opset[i].getOpt()[j].getName().equals(optionName)) {
						opset[i].getOpt()[j].setPrice(price);
					}
				}
			}
		}
	}
	//Print out all information
	/**
	 * Print basic information.
	 */
	public void printBasicInfo(){
		System.out.println("The following information is model basic information: ");
		System.out.println();
		System.out.println("# Car model: " + getName());
		System.out.println("# Base price: $" 
		                  + String.format("%.2f", getBasePrice()));
		System.out.println();
	}
	
	/**
	 * Print all other additional information.
	 */
	public void printAdditionalInfo() {
		
		System.out.println("The following information is model additional information: ");
		System.out.println();
		for(int i=0;i<opset.length;i++){
			if(opset[i]!=null){
				System.out.println("#" + opset[i].getName() + ": ");
				opset[i].print();
			}else{
				System.out.println("This option set does not exist or has been deleted");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------");
	}
	
}
