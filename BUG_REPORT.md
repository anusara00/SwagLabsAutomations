# QA Bug Report: Swag Labs (`problem_user` Profile)

## Bug 1: Incorrect Product Images Rendered on Inventory Page
* **Environment:** Production (Sauce Demo)
* **Account:** `problem_user`
* **Description:** When logging into the inventory page, every single product displays the exact same incorrect image (a picture of a dog) instead of the actual product images.
* **Steps to Reproduce:**
    1. Navigate to https://www.saucedemo.com/
    2. Log in with username `problem_user` and password `secret_sauce`.
    3. Observe the product images on the inventory page.
* **Expected Result:** Each product card should display an image matching the specific item.
* **Actual Result:** All product image sources are identical, displaying an image of a dog.

---

## Bug 2: Product Sorting Dropdown is Non-Functional
* **Environment:** Production (Sauce Demo)
* **Account:** `problem_user`
* **Description:** The sorting filter on the top right of the inventory page fails to sort the items.
* **Steps to Reproduce:**
    1. Log in as `problem_user`.
    2. Click the sorting dropdown menu.
    3. Select "Name (Z to A)" or "Price (low to high)".
* **Expected Result:** The grid of products should instantly re-order to match the selected sorting criteria.
* **Actual Result:** The page remains static, and the products do not change their order.

---

## Bug 3: "Last Name" Field is Unusable During Checkout
* **Environment:** Production (Sauce Demo)
* **Account:** `problem_user`
* **Description:** A user cannot complete a purchase because the "Last Name" field on the checkout information page deletes user input and cannot be filled out.
* **Steps to Reproduce:**
    1. Log in as `problem_user`.
    2. Add any item to the cart and click "Checkout".
    3. Attempt to type text into the "Last Name" field.
* **Expected Result:** The user should be able to input their last name.
* **Actual Result:** Typing in the Last Name field automatically overwrites the input with a single character, blocking the user from proceeding.