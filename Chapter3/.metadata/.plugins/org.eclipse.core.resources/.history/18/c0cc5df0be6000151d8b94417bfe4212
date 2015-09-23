package model;

import java.io.Serializable;

/**
 * Each car has several option sets, such as car color, car transmission selection and so on.
 * For each option set, there is a lot of options and for each option, there is a name and a price.
 * So in order to establish a car configuration model, not only car option set should be considered,
 * but options selection also should be.
 * Two classes are included in this .java file. Optionset class is the outter class and Option 
 * class is the inner class of Optionset, which contains its option name and its option price.
 * <p>
 * Also in order to keep our option set data and option data from corruption, serialization
 * can be very helpful. So Serizalizable interface is implemented both in Optionset class and
 * Option class.
 * 
 *@author--Yi
 *@version--1.0
 *@since--Sep/14/2015
*/

//This class is to define option set for each model

public class Optionset implements Serializable{
	//Declare a serial version UID
		static final long serialVersionUID = 1;
		
	//Each optionset has a set of values
	private Option opt[];
	
	//Each model should have a name
	private String name;
	
	//Constructor: Default 
	protected Optionset(){}
	
	/**
	 * Constructor with arguments.
	 * @param name
	 * @param size
	 */
	protected Optionset(String name,int size){
		opt = new Option[size];
		this.name = name;
		
		//Create an object for each element in opt to avoid null pointer
		for(int i=0;i<size;i++){
			opt[i] = new Option();
			}
	}
	
	//Setters and getters
	/**
	 * To get optionset name.
	 * @return name
	 */
	protected String getName() {
		return name;
	}
	
	/**
	 * To set optionset name.
	 * @param name
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * To get option array.
	 * @return option array.
	 */
	protected Option[] getOpt() {
		return opt;
	}

	/**
	 * To set option array.
	 * @param opt
	 */
	protected void setOpt(Option[] opt) {
		this.opt = opt;
	}

	/**
	 * 1:Set option.
	 * @param optionIndex
	 * @param name
	 * @param price
	 */
	protected void setOption(int optionIndex,String name,float price) {
		opt[optionIndex].name = name;
		opt[optionIndex].price = price;
	}
	
	//2: Get option
	/**
	 * 2.1: Get option with its option index.
	 * @param optionIndex
	 * @return
	 */
	protected Option getOption(int optionIndex){
		if(opt[optionIndex]!=null){
			return opt[optionIndex];
		}
		return null;
	}
	
	/**
	 * 2.1: Get option with its option name.
	 * @param name
	 * @return
	 */
	protected Option getOption(String name){
		for(int i=0;i<opt.length;i++){
			if(opt[i]!=null && opt[i].getName().equals(name)){
				return opt[i];
			}
		}
		return null;
	}
	
	//3. Delete option
	/**
	 * 3.1: Delete option with its name.
	 * @param name
	 */
	protected void deleteOption(String name){
		for(int i=0;i<opt.length;i++){
			if(opt[i]!=null && opt[i].getName().equals(name)){
				opt[i] = null;
			}
		}
	}
	
	/**
	 * 3.2: Delete option with its option index.
	 * @param optionIndex
	 */
	protected void deleteOption(int optionIndex){
		if(optionIndex<opt.length && optionIndex>=0){
			if(opt[optionIndex]!=null){
				opt[optionIndex] = null;
			}
		}
	}
	
	//4. Update option name
	/**
	 * 4.1: Update option name with its old name.
	 * @param oldName
	 * @param newName
	 */
	protected void updateOptionName(String oldName, String newName){
		if(getOption(oldName) == null) return;
		else{
			getOption(oldName).setName(newName);
		}
	}
	
	/**
	 * 4.2: Update option name with its old index.
	 * @param optionIndex
	 * @param newName
	 */
	protected void updateOptionName(int optionIndex, String newName){
		if(getOption(optionIndex) == null) return;
		else{
			getOption(optionIndex).setName(newName);
		}
	}
	
	//5. Update option price
	/**
	 * 5.1: Update option price with its name.
	 * @param name
	 * @param price
	 */
		protected void updateOptionPrice(String name, float price){
			if(getOption(name) == null) return;
			else{
				getOption(name).setPrice(price);
			}
		}
		
		/**
		 * 5.2: Update option price with its index.
		 * @param optionIndex
		 * @param price
		 */
		protected void updateOptionPrice(int optionIndex, float price){
			if(getOption(optionIndex) == null) return;
			else{
				getOption(optionIndex).setPrice(price);
			}
		}
	
		
		/**
		 * Print out all information in one option set.
		 */
		protected void print(){
			for(int i=0;i<opt.length;i++){
				if(opt[i]!=null){
					System.out.println(opt[i].getName() + ": $"
				                      + String.format("%.2f", opt[i].getPrice()));
				}else{
					System.out.println("This option does not exist or has been deleted!");
				}
			}
		}
		
	protected class Option implements Serializable{
		//Declare a serial version UID
		static final long serialVersionUID = 1;
		
		//Each option set should have an exact option name
		private String name;
		
		//Each option should have a according price
		private float price;
		
		//Constructor
		/**
		 * Default constructor.
		 */
		protected  Option(){}
		
		/**
		 * Constructor with arguments.
		 * @param name
		 * @param price
		 */
		protected  Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		//Setters and getters
		/**
		 * To set option set.
		 * @param name
		 */
		protected void setName(String name) {
			this.name = name;
		}
		
		/**
		 * To set option price.
		 * @param price
		 */
		protected void setPrice(float price) {
			this.price = price;
		}
		
		/**
		 * To get the option name.
		 * @return
		 */
		protected String getName() {
			return this.name;
		}
		
		/**
		 * To set the option price.
		 * @return
		 */
		protected float getPrice() {
			return this.price;
		}
	}
}
