#!/usr/bin/env sh

# abort on errors
set -e

# build
yarn docs:build

# navigate into the build output directory
cd docs/.vuepress/dist

git add -A
git commit -m 'deploy'

# if you are deploying to https://<USERNAME>.github.io/<REPO>
git push -f origin gh-pages

cd -