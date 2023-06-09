# Imgur

Application that searches for the top images of the week from the Imgur gallery and displays them in a list. 
Development done using MVVM Clean architecture pattern. Api used - https://api.imgur.com/3/gallery/top/week

## Features
- Search top images of the week
- Toggle from Grid to List view
- Filter Images based on search
- Unit tests 
- Code comments to help understand the code
- Dependency Injection using Dagger Hilt

## Instruction To Run App
- Clone / Download repository using  [Repo Link]https://github.com/sreyans01/Imgur.git)
- Open Imgur project in Android Studio
- Build Project
- Select device/emulator and run

## Assumptions
- Have handled scenarios like no network, no response from api, error in Api response
- Have included data which has only image and excluded videos and other file formats
- Have written two unit test, we can write similar tests for other parts of the app

# App Screens
<table>
  <tr>
    <td>First Screen Page in List View</td>
     <td>Search Display Result in List View</td>
  </tr>
  <tr>
    <td>
<img src="https://github.com/sreyans01/Outputs/blob/18677f8ffd0a86529257af249e366b29dcdc1e26/Item_List_Display.JPEG" height="450" width="230" ></td>
    <td><img src="https://github.com/sreyans01/Outputs/blob/18677f8ffd0a86529257af249e366b29dcdc1e26/Item_Search_List.JPEG" height="450" width="230" ></td>
  </tr>
  </table>
  
  
  <table>
  <tr>
    <td>First Screen Page in Grid View</td>
     <td>Search Display Result in Grid View</td>
  </tr>
  <tr>
    <td><img src="https://github.com/sreyans01/Outputs/blob/18677f8ffd0a86529257af249e366b29dcdc1e26/Item_Grid_Display.JPEG" height="450" width="230" ></td>
    <td><img src="https://github.com/sreyans01/Outputs/blob/18677f8ffd0a86529257af249e366b29dcdc1e26/Item_Search_Grid.JPEG" height="450" width="230" ></td>
  </tr>
  </table>


