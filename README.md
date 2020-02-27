# Stack with Minimum in Constant Time
Stack that retrieves the minimum element in constant time.

### How it works
This Stack holds an auxiliary stack to keep track of the minimum values.  
The top value of the auxiliary stack is **always** equals to the minimum value present in the main stack.

### Trace table

`Stack stack = new StackCC();`  
Initializing the StackCC class.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
|             |                 |

`stack.push(10);`  
**10** is pushed to main stack. The value is also pushed to auxiliary stack since it is empty.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **10**      | **10**          |

`stack.push(5);`  
**5** is pushed to main stack. As the value is less than the top of auxiliary stack, the value is also pushed to it.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **5**       | **5**           |
| 10          | 10              |

`stack.push(15);`  
**15** is pushed to main stack. As the value is greater than the top of auxiliary stack, nothing happens to auxiliary stack.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **15**      |                 |
| 5           | **5**           |
| 10          | 10              |

`stack.push(3);`  
**3** is pushed to main stack. As the value is less than the top of auxiliary stack, the value is also pushed to it.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **3**       |                 |
| 15          | **3**           |
| 5           | 5               |
| 10          | 10              |

`stack.pop();`  
**3** is removed from the main stack. As the value is equals to top of auxiliary stack, it is also removed.

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **15**      |                 |
| 5           | **5**           |
| 10          | 10              |

`int minimum = stack.getMin();`  
**getMin()** returns **5**, the top of the auxiliary stack (a constant time operation).

| Main Stack  | Auxiliary Stack |
|:-----------:|:---------------:|
| **15**      |                 |
| 5           | **5**           |
| 10          | 10              |
