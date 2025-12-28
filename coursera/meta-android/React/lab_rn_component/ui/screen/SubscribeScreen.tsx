import {Alert, StyleSheet, View} from "react-native";
import {LittleLemonLogo} from "../component/LittleLemonLogo.tsx";
import {TitleText} from "../component/TitleText.tsx";
import {EmailInputText} from "../component/EmailInputText.tsx";
import {useState} from "react";
import {RoundedButton} from "../component/RoundedButton.tsx";

export function SubscribeScreen() {
    const [email, onEmailChange] = useState('')

    return (
        <View style={ styles.container }>
            <LittleLemonLogo />

            <View style={ styles.spacer } />

            <TitleText
                text={ "Subscribe to our newsletter for our latest delicious recipes!" }
                fontWeight={ '400' }
            />

            <View style={ styles.spacer } />

            <EmailInputText value={ email } onChangeText={ onEmailChange } />

            <View style={ styles.spacer } />

            <RoundedButton
                title="Subscribe"
                disabled={ email === '' }
                onPress={() => {
                    Alert.alert(
                        'Thanks for subscribing',
                        'Stay tuned!',
                        [{ text: 'OK' }]
                    );
                }}
            />
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 25
    },
    spacer: {
        height: 25
    }
})