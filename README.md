## Android RTL bugs

Demo project to showcase 4 Android bugs related to right-to-left locales (like Arabic).

#### Bug 1 - Font (https://issuetracker.google.com/issues/110104699)
After activity restart, Android doesn't select the font from the correct resource bucket

#### Bug 2 - LinearLayout Divider (https://issuetracker.google.com/issues/110104700)
android:showDividers="middle" doesn't render dividers correctly in RTL

#### Bug 3 - RecyclerView ItemDecoration (https://issuetracker.google.com/issues/110132578)
ItemDecoration doesn't render space between recycler view items correctly in RTL

#### Bug 4 - ViewPager direction (https://issuetracker.google.com/issues/71339606)
ViewPager doesn't flip the position of the views in RTL
Third party alternative which works correctly 
- https://github.com/diego-gomez-olvera/RtlViewPager
