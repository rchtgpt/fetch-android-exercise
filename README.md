# Fetch Android Exercise

### Design Decisions:
1. **MVVM Architecture:**  
I implemented the Model-View-ViewModel (MVVM) architecture to cleanly separate business logic (data handling) from the UI components, ensuring better structure and maintainability.

2. **Color Coding for Grouping:**  
   I used color coding to visually differentiate items by their `listId`, making it easier to identify which group an item belongs to in the UI.

3. **Sorting by List and Name:**  
   I followed the prompt by first sorting the items by their `listId`. Then, **within** each group (with the same `listId`), I sorted them alphabetically by `name`.

4. **String vs. Numeric Sorting:**  
   The `name` field contains Strings, so sorting treats "Item 211" as coming before "Item 39" (because it compares Strings alphabetically, not numerically). I assumed you wanted this behavior since the prompt didn't specify sorting by `id` for numeric ordering.

5. **Comprehensive Documentation:**  
   I included KDoc comments throughout the codebase to explain each class and function, making the code more understandable for other developers.

6. **Modular Code Design:**  
   I structured the code into separate files for reusable components, promoting modularity, code reuse, and ease of maintenance.

### Video Demo


