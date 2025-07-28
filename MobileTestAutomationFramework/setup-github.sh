#!/bin/bash

# Script to initialize Git repository and prepare for GitHub upload to existing repository

echo "Setting up Git repository for Mobile Test Automation Framework..."

# Initialize Git repository if not already initialized
if [ ! -d .git ]; then
    echo "Initializing Git repository..."
    git init
    echo "Git repository initialized."
else
    echo "Git repository already initialized."
fi

# Add all files to Git
echo "Adding files to Git..."
git add .
echo "Files added to Git."

# Commit changes
echo "Committing changes..."
git commit -m "Add Mobile Test Automation Framework"
echo "Changes committed."

# Instructions for GitHub upload to existing repository
echo ""
echo "==== GITHUB UPLOAD INSTRUCTIONS ===="
echo ""
echo "To upload this framework to your existing 'Automation' GitHub repository, follow these steps:"
echo ""
echo "1. Connect your local repository to your existing GitHub repository:"
echo "   Run the following commands in this directory:"
echo ""
echo "   git remote add origin https://github.com/Sunidhi1996/Automation.git"
echo "   git fetch origin"
echo ""
echo "2. Create a new branch for the mobile test automation framework:"
echo "   git checkout -b mobile-test-automation"
echo ""
echo "3. Push your code to the new branch:"
echo "   git push -u origin mobile-test-automation"
echo ""
echo "4. Create a Pull Request on GitHub:"
echo "   - Go to https://github.com/Sunidhi1996/Automation/pull/new/mobile-test-automation"
echo "   - Set the base branch to 'main'"
echo "   - Set the compare branch to 'mobile-test-automation'"
echo "   - Click 'Create pull request'"
echo "   - Add a title and description for your pull request"
echo "   - Click 'Create pull request' again"
echo ""
echo "5. Merge the Pull Request:"
echo "   - Once the pull request is created, you can merge it by clicking the 'Merge pull request' button"
echo ""
echo "==== END OF INSTRUCTIONS ===="
echo ""
echo "Setup complete! You can now follow the instructions above to upload to your existing GitHub repository."
