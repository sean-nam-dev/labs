import LittleLemonAppBar from "./LittleLemonAppBar.tsx";
import {LittleLemonScaffold} from "./LittleLemonScaffold.tsx";

export function MainScreen() {
    return (
      <>
          <LittleLemonAppBar
              text={ "Little Lemon" }
              textSize={ 40 }
          />
          <LittleLemonScaffold />
      </>
    )
}