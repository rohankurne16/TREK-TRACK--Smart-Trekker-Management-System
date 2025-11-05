# 🏔️ TrekTrack – Smart Trekker Management System

TrekTrack is a **smart & efficient management system** designed to handle trekker registration, authentication, and record management.  
The system allows trekkers to **register, log in, update information, reset passwords**, and **delete accounts**.  
An **admin panel** provides access to view all registered trekkers, manage records, and **export data securely** to files.

---

## 🚀 Features
- 👤 Trekker Registration & Login  
- 🗂️ View and Manage Trekker Records  
- ✏️ Update or Delete Trekker Data  
- 🔑 Password Reset Functionality  
- 💾 Export Trekker Data to pdf File  
- 🧭 Admin Access for All Records  

---

## 🛠️ Tech Stack
| Layer | Technology |
|-------|-------------|
| **Backend** | Java (JDBC) |
| **Database** | MySQL |
| **File Handling** | Java `FileWriter` |
| **IDE Used** | Eclipse IDE |

---

## ⚙️ How It Works
1. Trekker registers and logs in using credentials.
2. Data is stored in a MySQL database (`trekker` table).
3. Admin can export all trekker data to a formatted text file using `ExportDAO`.
4. File is automatically saved to `D:\FileHandling\Trekdata.pdf`.

---
