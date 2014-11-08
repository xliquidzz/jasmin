*Jasmin*
======

**Easy and simple but powerful knowledge base management with a modern and fast architecture. Java based backend with a RESTful JSON API and a HTML 5 client.**

*Copyright (C) 2014 Marcus Fihlon*

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.

# How to contribute to *Jasmin*

## Source code management

### GIT Workflow Rules

1. Fork the repository only, if you want to contribute. If read only access is enough for you, simply clone this repository directly or download the ZIP file.
2. Don’t modify the master branch directly. Touch the master branch only when merging in a feature branch.
3. Use feature branches for every kind of modifications, including fixes. Name the branch with the issue number and the title. If there is no issue for your change, create one.
4. When you commit your work, always mention the issue number in the commit message.
5. When you merge the feature branch into the master branch, don’t use fast forward (`-no-ff`)!
6. After merging, tag the master branch for archiving. Use the same name for the tag as for the feature branch, prefixed by “archive/“.
7. If it is no longer in use, delete the feature branch.
8. When you push the master branch from your clone to your fork, push the archiving tag, too!
9. To get your changes integrated into this repository, create a pull request on GitHub

### Example of the GIT Workflow

1. If not already done, fork the *Jasmin* repository using GitHub and clone your fork locally:<br/>`git clone https://github.com/[YourUsername]/jasmin`
2. Create the feature branch:<br/>`git checkout -b 42-update-dropwizard`
3. Make your changes and commits:<br/>`git add build.gradle`<br/>`git commit -m ‘#42 Updated DropWizard to 0.7.1’`
4. Keep the feature branch up-to-date:<br/>`git rebase master`
5. Merge the feature branch to the master branch:<br/>`git checkout master`<br/>`git merge --no-ff 42-update-dropwizard`
6. Tag the master branch for archiving:<br/>`git tag archive/42-update-dropwizard`
7. Delete the feature branch:<br/>`git branch -d 42-update-dropwizard`
8. Push changes to your own fork:<br/>`git push origin master`<br/>`git push origin archive/42-update-dropwizard`
9. Create a pull request using GitHub.

### Keep your fork in sync

If you fork this repository, GitHub will not keep your fork in sync with this repository. You have to do it on your own.

1. If not already done, add this repository as an upstream to your repository:<br/>`git remote add upstream https://github.com/McPringle/jasmin.git`
2. Verify that this repository was added successfully:<br/>`git remote -v`
3. Fetch branches and commits from this repository to your local branch `upstream/master`:<br/>`git fetch upstream`
4. If you are not on your local master branch, check it out:<br/>`git checkout master`
5. Merge the changes from this repository into your repository:<br/>`git merge upstream/master`
7. Push your updated repository to your GitHub fork:<br/>`git push origin master`

### Frequently Asked Questions

1. When I try to push, I get a `non-fast-forward updates were rejected` error.<br/>*Your local copy of a repository is out of sync with, or behind the upstream repository, you are pushing to. You must retrieve the upstream changes, before you are able to push your local changes.*