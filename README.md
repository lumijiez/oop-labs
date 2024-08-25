# OOP Laboratory Project: File Change Detection System

## Overview

This project is a file change detection system developed in Java using object-oriented principles like inheritance and polymorphism. The program monitors a designated folder for changes in files and provides real-time feedback about those changes through a graphical user interface (GUI). It mimics a simplified version of Git functionality, tracking file changes, additions, and deletions.

## Features

### 1. File Change Detection
The system continuously monitors the specified folder for any changes to files, such as modifications to their content. When a file is changed, the system detects the change and updates its internal snapshot to reflect the new state.

### 2. File Addition and Deletion Detection
The program not only tracks changes within existing files but also detects when files are added or deleted in the monitored folder. This ensures comprehensive coverage of all file activities within the folder.

### 3. Real-Time Monitoring
The system operates in real-time with no delay. Changes are immediately reflected in the GUI as soon as they occur. The user can see updates instantly without needing to refresh or wait.

### 4. User Commands Through GUI
The program includes an intuitive GUI that allows the user to execute the following commands:

- **`Commit`**: Updates the snapshot time to the current time, marking the state of all files as unchanged since this new snapshot.
- **`Info <filename>`**: Displays detailed information about the specified file. This includes:
  - For **text files**: Line count, word count, and character count.
  - For **image files**: Dimensions (e.g., 1024x860).
  - For **program files**: Line count, class count, and method count.
- **`Status`**: Provides an overview of the current status of all monitored files, indicating whether they have changed since the last snapshot.

### 5. Interactive GUI
The GUI is designed to be user-friendly and interactive, making it easy to monitor changes in real-time and execute commands. The interface automatically updates to reflect the current state of the folder, and users can perform all necessary actions directly through the GUI.

## How It Works

- **Inheritance & Polymorphism**: The program is structured using Java’s inheritance and polymorphism features. A base class represents generic file operations, while specific file types (e.g., text files, image files) extend this base class, implementing specialized behavior for each file type.
  
- **Multithreading**: The real-time monitoring and instant updates are achieved through multithreading. This allows the GUI to remain responsive while simultaneously tracking changes in the folder.

## Example Usage

### Commit Command
```bash
> commit
Snapshot updated to 2023-10-11, 09:01:28. No changes detected.
```

### Info Command
```bash
> info test.txt
File: test.txt
Type: Text File
Lines: 120
Words: 850
Characters: 6500
```

### Status Command
```bash
> status
test.txt - No changes since last snapshot.
image.png - Modified since last snapshot.
python_script.py - No changes since last snapshot.
```

### Real-Time Monitoring Output
```bash
Change detected: image.png modified at 2023-10-11, 09:06:15
Change detected: newfile.txt added at 2023-10-11, 09:07:00
```

## Conclusion

This project demonstrates the effective use of inheritance and polymorphism in Java to create a fully functional file change detection system. The program is designed to be user-friendly, offering real-time monitoring, an intuitive GUI, and a comprehensive set of features to track and display file changes as they happen.
