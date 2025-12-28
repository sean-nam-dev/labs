import {Image, StyleSheet} from "react-native";

export function LittleLemonLogo() {
    return (
        <Image
            style={ styles.logo }
            resizeMode='stretch'
            source={ require('../src/little-lemon-logo.png') }
        />
    )
}

const styles = StyleSheet.create({
    logo: {
        alignSelf: "center",
        width: 130,
        height: 155
    }
})