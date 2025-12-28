import {Image, StyleSheet} from "react-native";

export function LittleLemonImage() {
    return (
        <Image
            style={ styles.image }
            resizeMode='stretch'
            source={ require('../src/little-lemon-image.png') }
        />
    )
}

const styles = StyleSheet.create({
    image: {
        alignSelf: 'center',
        width: 150,
        height: 265
    }
})