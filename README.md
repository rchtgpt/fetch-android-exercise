# Fetch Android Exercise

### Task
> Please write a native Android app in Kotlin or Java that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.
> Display this list of items to the user based on the following requirements:
>
> Display all the items grouped by "listId"
> Sort the results first by "listId" then by "name" when displaying.
> Filter out any items where "name" is blank or null.
> The final result should be displayed to the user in an easy-to-read list.
>
> Please make the project buildable on the latest (non-pre release) tools and supporting the current release mobile OS.



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

### Screenshots of Scrollable Item List
<img width="483" alt="image" src="https://github.com/user-attachments/assets/1d47396c-1c91-447c-8d7d-df6792a00cce">
<img width="481" alt="image" src="https://github.com/user-attachments/assets/58c914d2-a358-454d-a934-d7464de311ef">



