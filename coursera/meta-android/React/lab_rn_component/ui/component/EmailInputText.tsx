import {StyleSheet, TextInput} from "react-native";

type Props = {
    value: string
    onChangeText: (text: string) => void
}

export function EmailInputText({
    value,
    onChangeText
}: Props) {
    return (
        <TextInput
            style={ styles.textInput }
            value={ value }
            onChangeText={ onChangeText }
            placeholder={ "Type your email" }
            keyboardType='email-address'
        />
    )
}

const styles = StyleSheet.create({
    textInput: {
        width: '100%',
        borderRadius: 8,
        borderWidth: 3,
        borderColor: '#40524c',
        fontSize: 22,
        padding: 10,
        color: '#40524c'
    }
})