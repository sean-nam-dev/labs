import {StyleSheet, View} from "react-native";
import LittleLemonAppBar from "./LittleLemonAppBar.tsx";
import {TextField} from "./TextField.tsx";
import {LittleLemonScaffold} from "./LittleLemonScaffold.tsx";

export function MainScreen() {
    return (
      <View style={ styles.container }>
          <LittleLemonAppBar
              text={ "Little Lemon" }
              textSize={ 40 }
          />
          <TextField />
          <LittleLemonScaffold />
      </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'white'
    }
})