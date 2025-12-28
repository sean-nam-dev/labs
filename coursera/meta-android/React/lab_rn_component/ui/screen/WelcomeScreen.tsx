import {StyleSheet, View} from "react-native";
import {LittleLemonImage} from "../component/LittleLemonImage.tsx";
import {TitleText} from "../component/TitleText.tsx";
import {RoundedButton} from "../component/RoundedButton.tsx";

export function WelcomeScreen({ navigation }) {
    return (
        <View style={ styles.container }>
            <View style={ styles.spacer } />

            <View style={ styles.centerContent } >
                <LittleLemonImage />

                <View style={ styles.innerSpacer } />

                <TitleText
                    text={ "Little Lemon, your local Mediterranean Bistro" }
                    fontWeight={ 'bold' }
                />
            </View>

            <View style={ styles.spacer } />

            <RoundedButton
                title={ "Newsletter" }
                disabled={ false }
                onPress={ () => navigation.navigate('Subscribe')}
            />
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        paddingHorizontal: 25,
        paddingVertical: 40
    },
    centerContent: {
        alignItems: 'center'
    },
    spacer: {
        flex: 1
    },
    innerSpacer: {
        height: 100
    }
})