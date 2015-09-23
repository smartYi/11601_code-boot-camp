package chapter3;

import java.util.LinkedList;

/**
 * This class java file is to generate a simulation animal shelter.
 * This animal shelter only contains dogs and cats. People can adopt
 * one animal but the animal is restricted to the oldest animal of all 
 * animals or in the specific animal type. The age is based on the arrival
 * time, which means the first come-in animal must first out.
 * <p>
 * This character is quite the same as the queue, so an ainimal shelter
 * queue can be implemented for both dog and cat. And for any animals, 
 * a total queue is designed.
 * <p>
 * This simulation shelter contains four operations:
 * enequeue(): Add an animal to the end of the total queue and add to the 
 * specific queue according to their type;
 * dequeueAny(): Retrieve any animals from the total queue and also delete it
 * in the specific queue;
 * dequeueDog(): Retrieve the dog from the dog queue and delete it in the total queue;
 * dequeueCat(): Retrieve the cat from the cat queue and delete it in the total queue;
 * 
 * @author qiuyi
 *
 */
public class Solution06 {
	
	public static abstract class Animal {
		private int order;
		protected String name;
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//Constructor
		public Animal(String name) {
			this.name = name;
		}
		
		//Setters and getters
		
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		
		//To determine if an animal is younger than another one
		public boolean isYounger(Animal a) {
			return this.order < a.getOrder();
		}
		
	}
	
	//Dog class
	public static class Dog extends Animal {
		
		//Constructor
		public Dog(String name) {
			super(name);
		}
	}
	
	//Cat class
	public static class Cat extends Animal {
		
		//Constructor
		public Cat(String name) {
			super(name);
		}
	}
	
	//Animal queue class
	public static class AnimalQueue {
		
		private int order = 0;
		
		//Two array lists to represent two kinds of animals
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();
		
		/**
		 * This class is to add an animal to the end of the animal queue and set its entrance order.
		 * @param a true
		 */
		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;
			
			if(a instanceof Dog) dogs.addLast((Dog) a);
			else if(a instanceof Cat) cats.addLast((Cat) a);
		}
		
		
		/**
		 * This method is to dequeue an animal from the animal queue.
		 * @return Animal true
		 */
		public Animal dequeueAny() {
			
			if(dogs.size() == 0) {
				return dequeueCat();
			}else if(cats.size() == 0) {
				return dequeueDog();
			}
			
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if(dog.isYounger(cat)) {
				return dequeueDog();
			}else {
				return dequeueCat();
			}
		}
		
		/**
		 * This method is to dequeue a dog from the dog queue.
		 * @return
		 */
		public Dog dequeueDog() {
			System.out.println("A dog has been retrieved successfully");
			return dogs.poll();
		}
		
		/**
		 * This method is to dequeue a cat from the cat queue.
		 * @return
		 */
		public Cat dequeueCat() {
			System.out.println("A cat has been retrieved successfully");
			return cats.poll();
		}
		
		public void print() {
			while(dogs.size() != 0 || cats.size() != 0) {
				
			if(dogs.size() == 0) {
				System.out.print(cats.removeFirst().getName() + "-->");
			}else if(cats.size() == 0) {
				System.out.print(dogs.removeFirst().getName() + "-->");
			}else {
				Dog dog = dogs.peek();
				Cat cat = cats.peek();
				if(dog.isYounger(cat)) {
					System.out.print(dogs.removeFirst().getName() + "-->");
					}else {
						System.out.print(cats.removeFirst().getName() + "-->");
						}
				}
			}
		}
	}
	
	
	//Main function 
	public static void main(String[] args) {
		
		AnimalQueue animal = new AnimalQueue();
		Cat cat1 = new Cat("cat1");
		Cat cat2 = new Cat("cat2");
		Cat cat3 = new Cat("cat3");
		Cat cat4 = new Cat("cat4");
		Cat cat5 = new Cat("cat5");
		Dog dog1 = new Dog("dog1");
		Dog dog2 = new Dog("dog2");
		Dog dog3 = new Dog("dog3");
		Dog dog4 = new Dog("dog4");
		Dog dog5 = new Dog("dog5");
		
		animal.enqueue(cat1);
		animal.enqueue(dog1);
		animal.enqueue(cat2);
		animal.enqueue(dog2);
		animal.enqueue(cat3);
		animal.enqueue(dog3);
		animal.enqueue(cat4);
		animal.enqueue(dog4);
		animal.enqueue(cat5);
		animal.enqueue(dog5);
		
		//Test
		System.out.println("----------------------");
		System.out.println("A dog is removed from the queue: ");
		animal.dequeueDog();
		System.out.println("A cat is removed from the queue:");
		animal.dequeueCat();
		System.out.println("A cat or a dog is removed from the queue:");
		animal.dequeueAny();
		System.out.println("----------------------");
		System.out.println("Tests completed successfully!");
	}
	
}
